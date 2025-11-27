package com.javaweb.repository.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.model.BuildingSearchRequest;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	static final String url = "jdbc:mysql://localhost:3306/estatebasic";
	static final String username = "root";
	static final String password = "123123";
	
	@Override
	public List<BuildingEntity> findAll(BuildingSearchRequest request) {
		List<BuildingEntity> result = new ArrayList<BuildingEntity>();
		StringBuilder select = new StringBuilder("SELECT b.*, d.name AS district_name, "
											+ "GROUP_CONCAT(DISTINCT ra.value) AS rentarea_list, "
											+ "GROUP_CONCAT(DISTINCT rt.code) AS renttype_list  ");
		StringBuilder from = new StringBuilder("FROM building b " );
		StringBuilder where = new StringBuilder("Where 1=1 ");
		StringBuilder group = new StringBuilder("Group by b.id ");
		from.append("LEFT JOIN district d ON d.id = b.districtid ");
		from.append("LEFT JOIN rentarea ra ON ra.buildingid = b.id ");
		from.append("LEFT JOIN buildingrenttype brt ON brt.buildingid = b.id ");
		from.append("LEFT JOIN renttype rt ON rt.id = brt.renttypeid ");
		if(request.getNameBuilding()!=null&&!request.getNameBuilding().isEmpty()) {
			where.append("AND b.name like '%"+request.getNameBuilding()+"%' ");
		}
		if(request.getFloorarea()!=null) {
			where.append("AND b.floorarea = "+request.getFloorarea()).append(" ");
		}
		if(request.getDistrictId()!=null) {
//			select.append(", d.name AS district_name");
//			from.append("LEFT JOIN district d ON d.id = b.districtid ");
			where.append("AND d.id = "+request.getDistrictId()).append(" ");
		}
		if(request.getWard()!=null&&!request.getWard().isEmpty()) {
			where.append("AND b.ward like '%"+request.getWard()+"%' ");
		}
		if(request.getStreet()!=null&&!request.getStreet().isEmpty()) {
			where.append("AND b.street like '%"+request.getStreet()+"%' ");
		}
		if(request.getNumberOfBasement()!=null) {
			where.append("AND b.numberofbasement = "+request.getNumberOfBasement()).append(" ");
		}
		if(request.getDirection()!=null&&!request.getDirection().isEmpty()) {
			where.append("AND b.direction = '"+request.getDirection()+"'").append(" ");
		}
		if(request.getLevel()!=null&&!request.getLevel().isEmpty()) {
			where.append("AND b.level = "+request.getLevel()).append(" ");
		}
		if(request.getRentAreaFrom()!=null&&request.getRentAreaTo()!=null) {
//			select.append(", ra.value AS value ");
//			from.append("LEFT JOIN rentarea ra ON ra.buildingid = b.id ");
			where.append("AND ra.value >= "+request.getRentAreaFrom()).append(" AND ra.value <= "+request.getRentAreaTo()).append(" ");
		}
		if(request.getRentAreaFrom()!=null) {
//			select.append(", ra.value ");
//			from.append("JOIN  rentarea ra ON ra.buildingid = b.id ");
			where.append("AND ra.value = "+request.getRentAreaFrom()).append(" ");
		}
		if(request.getRentAreaTo()!=null) {
//			select.append(", ra.value ");
//			from.append("JOIN  rentarea ra ON ra.buildingid = b.id ");
			where.append("AND ra.value = "+request.getRentAreaTo()).append(" ");
		}
		if(request.getRentPriceFrom()!=null&&request.getRentPriceTo()!=null) {
			where.append("AND b.rentprice >= "+request.getRentPriceFrom()).append(" AND b.rentprice <= "+request.getRentPriceTo()).append(" ");
		}
		if(request.getRentPriceFrom()!=null) {
			where.append("AND b.rentprice = "+request.getRentPriceFrom()).append(" ");
		}
		if(request.getRentPriceTo()!=null) {
			where.append("AND b.rentprice = "+request.getRentPriceTo()).append(" ");
		}
		if(request.getNameManager()!=null&&!request.getNameManager().isEmpty()) {
			where.append("AND b.managername = '"+request.getNameManager()+"'").append(" ");
		}
		if(request.getNumberManeger()!=null&&!request.getNumberManeger().isEmpty()) {
			where.append("AND b.managerphonenumber = '"+request.getNumberManeger()+"'").append(" ");
		}
		if(request.getStaffId()!=null) {
			from.append("LEFT JOIN assignmentbuilding ass ON ass.buildingid = b.id ");
//			where.append("AN  ass.buildingid = b.id ");
			where.append("AND ass.staffid = "+request.getStaffId()).append(" ");
		}
		if(request.getRentType()!=null&&!request.getRentType().isEmpty()) {
//			select.append(", rt.name AS rentype_name ");
//			from.append("LEFT JOIN buildingrenttype brt ON brt.buildingid = b.id ").append("LEFT JOIN renttype rt ON rt.id = brt.renttypeid ");
//			where.append("AND brt.buildingid = b.id AND rt.id = brt.renttypeid ");
//			where.append("AND rt.code = '"+request.getRentType()+"'").append(" ");
			StringBuilder renttypeList = new StringBuilder();
			for(int i=0;i<request.getRentType().size();i++) {
				if(i>0) renttypeList.append(", ");
				renttypeList.append("'"+request.getRentType().get(i)+"'");
			}
			where.append("AND rt.code IN ("+renttypeList.toString()+") ");
		}
		try {
			Connection con = (Connection) DriverManager.getConnection(url, username, password);
			Statement stmt = (Statement) con.createStatement();
			String finalsql = select.toString()+from.toString()+ where.toString()+group.toString();
			ResultSet rs = stmt.executeQuery(finalsql);
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setNamebuilding(rs.getString("name"));
				building.setFloorarea(rs.getInt("floorarea"));
//				building.setDistrictname(rs.getString("district_name"));
				building.setWard(rs.getString("ward"));
				building.setStreet(rs.getString("street"));
				building.setNumberofbasement(rs.getInt("numberofbasement"));
				building.setDirection(rs.getString("direction"));
				building.setLevel(rs.getString("level"));
//				building.setRentarea(rs.getInt("value"));
				building.setRentprice(rs.getInt("rentprice"));
				building.setNamemanager(rs.getString("managername"));
				building.setNumbermanager(rs.getString("managerphonenumber"));
//				building.setStartid(rs.getInt("staffid"));
//				building.setRenttype(rs.getString("rentype_name"));
				building.setServicefee(rs.getInt("servicefee"));
				try {
					building.setDistrictname(rs.getString("district_name"));
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
//				try {
//					building.setRentarea(rs.getString("value"));
//				} catch (SQLException e) {
//					System.out.println(e.getMessage());
//				}
				String rentareaStr = rs.getString("rentarea_list");
				String[] values = rentareaStr.split(",");
				List<Integer> rentarea = new ArrayList<Integer>();
				for(String value : values) {
					rentarea.add(Integer.parseInt(value));
				}
				building.setRentarea(rentarea);
				
				String renttypeStr = rs.getString("renttype_list");
				String[] codes = renttypeStr.split(",");
				List<String> renttype = new ArrayList<String>();
				for(String code : codes) {
					renttype.add(code);
				}
				building.setRenttype(renttype);
				
				result.add(building);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
