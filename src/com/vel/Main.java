package com.vel;

import java.util.Scanner;

public class Main {
	 
	

	public static void main(String[] args) {
	
		Questions questions = new Questions();
		questions.getQuestionsFromDB();
		int score = questions.calculateScore();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter You Id :: ");
		int Id = sc.nextInt();
		System.out.println("Enter Your Name :: ");
		String name = sc.next();
		String grade = questions.calculateGrade();
		UserInput user = new UserInput();
		user.storeDataIntoDB(Id, name, score, grade);
		System.out.println("Your Score :: " +score);
		System.out.println("Your Grade >> " +grade);
	}

}
