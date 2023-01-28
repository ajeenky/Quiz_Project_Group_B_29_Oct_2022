package com.vel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Questions {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ArrayList<String> al = new ArrayList<String>();
	
	public void getQuestionsFromDB() {
		try {
			Scanner sc = new Scanner(System.in);
			ConnectionTest cont = new ConnectionTest();
			con = cont.getConnection();
			pstmt = con.prepareStatement("select * from quiz order by rand()");
			ResultSet res = pstmt.executeQuery();
			int i = 1;
			while (res.next()) {
				
				System.out.println(i+" "+res.getString(2));
				i++;
				System.out.println(res.getString(3)+"  "+res.getString(4)+"  "+res.getString(5)+"  "+res.getString(6));
				System.out.println("Enter a option");
				String input = sc.next();
				al.add(input);
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
}
