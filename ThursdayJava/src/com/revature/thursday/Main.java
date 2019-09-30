package com.revature.thursday;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String str;
		String sub;
		String userInput;
		//String userInput2;
		
		boolean test;
		boolean parseTest;
		//boolean parseTest2;
		
		int numRows = 5;
		int totalBlocks;
		int switchCase;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter desired method to test");
		System.out.println("1) substring");
		System.out.println("2)triangle");
		
		
		do {
			userInput =sc.nextLine();
			parseTest = Methods.tryParseInt(userInput);
		}
		while(parseTest == false);
		switchCase = Integer.parseInt(userInput);
		
		
		switch(switchCase) {
		
		case 1:
				System.out.println("Enter a string");
				str = sc.nextLine();
				
				System.out.println("Enter a subString");
				sub = sc.nextLine();
				
				test = Methods.subString(str, sub);
				System.out.println(test);
				sc.close();
				break;
		
		case 2:
				
				/*System.out.println("Enter number of rows");
				do {
					userInput2 = sc.nextLine();
					parseTest2 = Methods.tryParseInt(userInput2);
				}
				while(parseTest2 == false);
				numRows = Integer.parseInt(userInput);*/
				sc.close();
				totalBlocks = Methods.triangle(numRows);
				System.out.println(totalBlocks);
				break;
				
		default:{
				break;}
		
		}
	}

}
