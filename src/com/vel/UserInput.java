package com.vel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInput {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	
	public void storeDataIntoDB(int Id, String name, int score, String grade) {
		try {
			ConnectionTest cont = new ConnectionTest();
			con = cont.getConnection();
			pstmt = con.prepareStatement("insert into user_input(Id, Name, Score, Grade)values(?,?,?,?)");
			pstmt.setInt(1, Id);
			pstmt.setString(2, name);
			pstmt.setInt(3, score);
			pstmt.setString(4, grade);
			int i = pstmt.executeUpdate();
			System.out.println("Data added into DB for.."+1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
