package com.javaweb.repository.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

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
	public List<BuildingEntity> findAll(String name, Integer id) {
		List<BuildingEntity> result = new ArrayList<BuildingEntity>();
		StringBuilder sql = new StringBuilder("SELECT * FROM building Where 1=1 ");
		if(name!=null&&!name.equals(null)) {
			sql.append("AND name like '%"+name+"%' ");
		}
		if(id!=null) {
			sql.append("AND districtid = " +id );
		}
		try {
			Connection con = (Connection) DriverManager.getConnection(url, username, password);
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setNumberofbasement(rs.getInt("numberofbasement"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				result.add(building);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
