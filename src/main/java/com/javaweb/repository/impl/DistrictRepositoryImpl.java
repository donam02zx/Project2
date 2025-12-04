package com.javaweb.repository.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaweb.Utils.ConnectionJDBCUtil;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository {
	
	@Override
	public DistrictEntity findNameById(Long id) {
		DistrictEntity districtEntity = new DistrictEntity();
		StringBuilder sql = new StringBuilder("SELECT d.name FROM district AS d WHERE d.id = "+id);
		
		try(Connection conn = ConnectionJDBCUtil.getConnection();
				Statement stmt = (Statement) conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());) {
			while(rs.next()) {
				districtEntity.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return districtEntity;
	}

}
