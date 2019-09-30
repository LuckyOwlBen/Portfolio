package com.revature.thursday;

public class Methods {
	
	public static boolean subString(String str, String sub) {
		
		boolean test;
		
		test = str.contains(sub);
		
		return test;
	}
	
	public static int triangle(int numRows) {
		
		if(numRows == 1) {
			return 1;
		}
		
		return numRows + triangle(numRows - 1);
	}

	public static boolean tryParseInt(String string) {
		
		boolean test;
		
		try {
			
			Integer.parseInt(string);
			test = true;
		}
		catch(Exception e) {
			System.out.println("Invalid Input try again");
			test = false;
			return test;
		}
		
		return test;
	}
	
}
