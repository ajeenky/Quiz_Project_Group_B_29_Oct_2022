package com.vel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

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
	
    public void retrieveDataFromDB() {
		
		try {
			ConnectionTest cont = new ConnectionTest();
			con = cont.getConnection();
			pstmt = con.prepareStatement("select * from user_input order by Score DESC");
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getInt(3)+" "+res.getString(4));
			}
			
			res.close();
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
    
    public void getRecord() {
		try {
			ConnectionTest cont = new ConnectionTest();
			con = cont.getConnection();
			PreparedStatement statement = con.prepareStatement("select * from questions.user_input where id =  ?");
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter the id to check the score");
			int stuId = sc.nextInt();
			statement.setInt(1, stuId);
			ResultSet res = statement.executeQuery();
			while(res.next()) {
				System.out.println("Id = " +stuId+ " Name = " +res.getString("Name")+ " Score = " +res.getInt("Score")+ " Grade = " +res.getString("Grade"));
			}
			
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
