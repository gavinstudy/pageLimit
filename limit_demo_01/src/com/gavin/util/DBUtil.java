package com.gavin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql:///pms";
	private String username = "root";
	private String password = "123456";
	
	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rst = null;
	
	public Connection getConnection() throws SQLException {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
	public void close() throws SQLException {
		
		if(rst != null) {
			rst.close();
		}
		
		if(pstmt != null) {
			pstmt.close();
		}
		
		if(conn != null) {
			conn.close();
		}
		
	}
}
