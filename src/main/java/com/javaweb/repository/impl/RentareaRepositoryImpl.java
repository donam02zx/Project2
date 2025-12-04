package com.javaweb.repository.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.Utils.ConnectionJDBCUtil;
import com.javaweb.repository.RentareaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.RentareaEntity;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@Repository
public class RentareaRepositoryImpl implements RentareaRepository{

	@Override
	public List<RentareaEntity> findValue(Long id) {
//		RentareaEntity rentareaEntity = new RentareaEntity();
		List<RentareaEntity> result = new ArrayList<RentareaEntity>();
		StringBuilder sql = new StringBuilder("SELECT * FROM rentarea AS ra WHERE ra.buildingid = "+id);
		try(Connection conn = ConnectionJDBCUtil.getConnection();
				Statement stmt = (Statement) conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());) {
			while(rs.next()) {
				RentareaEntity rentareaEntity = new RentareaEntity();
				rentareaEntity.setValue(rs.getString("value"));
				result.add(rentareaEntity);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	
}
