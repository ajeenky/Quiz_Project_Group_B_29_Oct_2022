package com.vel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Questions {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ArrayList<String> al = null;
	ArrayList<String> al1 = null;
	
	public void getQuestionsFromDB() {
		al = new ArrayList<String>();
		al1 = new ArrayList<String>();
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
				al1.add(res.getString(7));
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
	public int calculateScore() {
		
		Iterator<String> itr = al.iterator();
		Iterator<String> itr1 = al1.iterator();
		int score = 0;
		while(itr.hasNext()) {
			itr1.hasNext();
			String s1 = itr.next();
			String s2 = itr1.next();
			if(s1.equals(s2)) {
				score = score + 1;
			}
		}
		return score;
	}
	public String calculateGrade() {
		int score = calculateScore();
		String grade = "";
		
		switch(score) {
			case 10:
				grade = "A";
				break;
			case 9:
				grade = "A";
				break;
			case 8:
				grade = "A";
				break;
			case 7:
				grade = "B";
				break;
			case 6:
				grade = "B";
				break;
			case 5:
				grade = "C";
				break;
			default:
				grade = "Fail";
		}
		
		return grade;
	}
}
