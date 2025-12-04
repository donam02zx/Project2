package com.javaweb.repository.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.javaweb.Utils.ConnectionJDBCUtil;
import com.javaweb.Utils.NumberUtil;
import com.javaweb.Utils.StringUtil;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{	
	public static void joinTable(Map<String,Object> param, List<String> typeCode, StringBuilder sql) {
		String staffId = (String)param.get("staffId");
		if(StringUtil.checkString(staffId)) {
			sql.append("LEFT JOIN assignmentbuilding assb ON assb.buildingid = b.id ");
		}
		if(typeCode!=null&&typeCode.size()!=0) {
			sql.append("LEFT JOIN buildingrenttype brt ON brt.buildingid = b.id ");
			sql.append("LEFT JOIN renttype rt ON rt.id = brt.renttypeid ");
		}
	}
	
	public static void queryNomal(Map<String,Object> param, StringBuilder where) {
		for(Map.Entry<String,Object> it:param.entrySet()) {
			if(!it.getKey().equals("staffId")&&!it.getKey().equals("typeCode")&&!it.getKey().startsWith("rentArea")
			   &&!it.getKey().startsWith("rentPrice")) {
				String value = it.getValue().toString();
				if(StringUtil.checkString(value)) {
					if(NumberUtil.isNumber(value)) {
						where.append("AND b."+it.getKey()+" = "+value).append(" ");
					}
					else {
						where.append("AND b."+it.getKey()+" LIKE '%"+value+"%'").append(" ");
					}
				}
			}
		}
	}
	
	public static void querySpecial(Map<String,Object> param, List<String> typeCode, StringBuilder where) {
		String staffId = (String)param.get("staffId");
		if(StringUtil.checkString(staffId)){
			where.append("AND assb.staffId = "+staffId).append(" ");
		}
		String rentAreaTo = (String)param.get("rentAreaTo");
		String rentAreaFrom = (String)param.get("rentAreaFrom");
		if(StringUtil.checkString(rentAreaFrom)==true||StringUtil.checkString(rentAreaTo)==true) {
			where.append("AND EXISTS (SELECT * FROM rentarea ra WHERE ra.buildingid = b.id ");
			if(StringUtil.checkString(rentAreaFrom)) {
				where.append("AND ra.value >= "+rentAreaFrom).append(" ");
			}
			if(StringUtil.checkString(rentAreaTo)) {
				where.append("AND ra.value <= "+rentAreaTo).append(" ");
			}
			where.append(") ");
		}
		String rentPriceTo = (String)param.get("rentPriceTo");
		String rentPriceFrom = (String)param.get("rentPriceFrom");
		if(StringUtil.checkString(rentPriceFrom)==true||StringUtil.checkString(rentPriceTo)==true) {
			if(StringUtil.checkString(rentPriceFrom)) {
				where.append("AND b.rentprice >= "+rentPriceFrom).append(" ");
			}
			if(StringUtil.checkString(rentAreaTo)) {
				where.append("AND b.rentprice <= "+rentPriceTo).append(" ");
			}
		}
		if(typeCode!=null&&typeCode.size()!=0) {
//			List<String> code = new ArrayList<String>();
//			for(String item:typeCode) {
//				code.add("'"+item+"'");
//			}
//			where.append("AND rt.code IN ("+String.join(",", code)+")").append(" ");
//			List<String> code = new ArrayList<String>();
//			where.append("AND (");
			String code = typeCode.stream().map(it->"rt.code like '%"+it+"%'").collect(Collectors.joining(" OR "));
			where.append("AND ("+code+") ");
		}
	}
	
	@Override
	public List<BuildingEntity> findAll(Map<String,Object> param, List<String> typeCode) {
		List<BuildingEntity> result = new ArrayList<BuildingEntity>();
		StringBuilder sql = new StringBuilder("SELECT b.id, b.name, b.districtid, b.street, b.ward, b.numberofbasement, "
												 + "b.floorarea, b.direction, b.level, b.rentprice, "
												 + "b.servicefee, b.managername, b.managerphonenumber FROM building b ");
		joinTable(param, typeCode, sql);
		StringBuilder where = new StringBuilder("Where 1=1 ");
		queryNomal(param, where);
		querySpecial(param, typeCode, where);
		sql.append(where);
		sql.append("Group By b.id ");
		try(Connection conn = ConnectionJDBCUtil.getConnection();
				Statement stmt = (Statement) conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());) {
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setId(rs.getLong("id"));
				building.setName(rs.getString("name"));
				building.setFloorarea(rs.getLong("floorarea"));
				building.setDistrictid(rs.getLong("districtid"));
				building.setWard(rs.getString("ward"));
				building.setStreet(rs.getString("street"));
				building.setNumberofbasement(rs.getLong("numberofbasement"));
				building.setDirection(rs.getString("direction"));
				building.setLevel(rs.getString("level"));
				building.setRentprice(rs.getLong("rentprice"));
				building.setNamemanager(rs.getString("managername"));
				building.setNumbermanager(rs.getString("managerphonenumber"));
				building.setServicefee(rs.getLong("servicefee"));

				result.add(building);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
