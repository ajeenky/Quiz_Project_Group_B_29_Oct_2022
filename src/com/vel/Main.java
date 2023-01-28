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
		
		user.retrieveDataFromDB();
		System.out.println("Press 1 to check your Score or Press 0 to exit");
		int temp = sc.nextInt();
		if(temp == 1) {
		user.getRecord();
		System.out.println("Thank you for your participation.");
		} else if (temp == 0) {
			System.out.println("Thank you for your participation.");
		}else {
			System.err.println("Invalid Input");
		}
		sc.close();
	}

}
