package com.javaweb.Utils;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionJDBCUtil {
	static final String url = "jdbc:mysql://localhost:3306/estatebasic";
	static final String username = "root";
	static final String password = "123123";
	
	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn = (Connection) DriverManager.getConnection(url, username, password);

		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
}
