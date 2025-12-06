package com.javaweb.repository.impl;

import java.lang.reflect.Field;
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
import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{	
	public static void joinTable(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		Long staffId = buildingSearchBuilder.getStaffId();
		if(staffId!=null) {
			sql.append("LEFT JOIN assignmentbuilding assb ON assb.buildingid = b.id ");
		}
		List<String> typeCode = buildingSearchBuilder.getTypeCode();
		if(typeCode!=null&&typeCode.size()!=0) {
			sql.append("LEFT JOIN buildingrenttype brt ON brt.buildingid = b.id ");
			sql.append("LEFT JOIN renttype rt ON rt.id = brt.renttypeid ");
		}
	}
	
	public static void queryNomal(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
//		for(Map.Entry<String,Object> it:param.entrySet()) {
//			if(!it.getKey().equals("staffId")&&!it.getKey().equals("typeCode")&&!it.getKey().startsWith("rentArea")
//			   &&!it.getKey().startsWith("rentPrice")) {
//				String value = it.getValue().toString();
//				if(StringUtil.checkString(value)) {
//					if(NumberUtil.isNumber(value)) {
//						where.append("AND b."+it.getKey()+" = "+value).append(" ");
//					}
//					else {
//						where.append("AND b."+it.getKey()+" LIKE '%"+value+"%'").append(" ");
//					}
//				}
//			}
//		}
		
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for(Field item:fields) {
				item.setAccessible(true);
				String fieldname = item.getName();
				if(!fieldname.equals("staffId")&&!fieldname.equals("typeCode")&&!fieldname.startsWith("rentArea")
						&&!fieldname.startsWith("rentPrice")) {
					Object value = item.get(buildingSearchBuilder);
					if(value!=null) {
						if(item.getType().getName().equals("java.lang.Long")||item.getType().getName().equals("java.lang.Integer")) {
							where.append("AND b."+fieldname+" = "+value).append(" ");
						}
						else if(item.getType().getName().equals("java.lang.String")) {
							where.append("AND b."+fieldname+" LIKE '%"+value+"%'").append(" ");
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void querySpecial(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
		Long staffId = buildingSearchBuilder.getStaffId();
		if(staffId!=null){
			where.append("AND assb.staffId = "+staffId).append(" ");
		}
		Long rentAreaTo = buildingSearchBuilder.getRentAreaTo();
		Long rentAreaFrom = buildingSearchBuilder.getRentAreaFrom();
		if(rentAreaFrom!=null||rentAreaTo!=null) {
			where.append("AND EXISTS (SELECT * FROM rentarea ra WHERE ra.buildingid = b.id ");
			if(rentAreaFrom!=null) {
				where.append("AND ra.value >= "+rentAreaFrom).append(" ");
			}
			if(rentAreaTo!=null) {
				where.append("AND ra.value <= "+rentAreaTo).append(" ");
			}
			where.append(") ");
		}
		Long rentPriceTo = buildingSearchBuilder.getRentPriceTo();
		Long rentPriceFrom = buildingSearchBuilder.getRentPriceFrom();
		if(rentPriceFrom!=null||rentPriceTo!=null) {
			if(rentPriceFrom!=null) {
				where.append("AND b.rentprice >= "+rentPriceFrom).append(" ");
			}
			if(rentPriceTo!=null) {
				where.append("AND b.rentprice <= "+rentPriceTo).append(" ");
			}
		}
		List<String> typeCode = buildingSearchBuilder.getTypeCode();
		if(typeCode!=null&&typeCode.size()!=0) {
			String code = typeCode.stream().map(it->"rt.code like '%"+it+"%'").collect(Collectors.joining(" OR "));
			where.append("AND ("+code+") ");
		}
	}
	
	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingsearchbuilder) {
		List<BuildingEntity> result = new ArrayList<BuildingEntity>();
		StringBuilder sql = new StringBuilder("SELECT b.id, b.name, b.districtid, b.street, b.ward, b.numberofbasement, "
												 + "b.floorarea, b.direction, b.level, b.rentprice, "
												 + "b.servicefee, b.managername, b.managerphonenumber FROM building b ");
		joinTable(buildingsearchbuilder, sql);
		StringBuilder where = new StringBuilder("Where 1=1 ");
		queryNomal(buildingsearchbuilder, where);
		querySpecial(buildingsearchbuilder, where);
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
