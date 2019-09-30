package com.revature.services;

public class ParseMethods {
	public double tryParseDouble(String userInput) {

		try {
			double number = Double.parseDouble(userInput);		//Attempts to use the wrapper class to parse a string into a double
			return number;
		}
		catch(Exception e){
			return 0;	//parse failed
		}
	}
	
	public int tryParseInt(String userInput) {
		try {
			int number = Integer.parseInt(userInput);
			return number;
		}catch(Exception e){
			return 0;
		}
	}
}
