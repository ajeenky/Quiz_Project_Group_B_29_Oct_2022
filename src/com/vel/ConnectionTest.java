package com.vel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectionTest {
	
	Connection con = null;
	PreparedStatement pst = null;

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questions","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
