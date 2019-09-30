package com.revature.strings;

public class Main {

	public static void main(String[] args) {
		String flip = "Pancakes";
		String drome = "tacocat";
		String flipped;
		boolean test;
		
		flipped = StringMethods.reversal(flip);
		System.out.println(flipped);
		
		test = StringMethods.palendrome(drome);
		System.out.println(test);
		
		flipped = StringMethods.recursiveReversal(flip);
		System.out.println(flipped);
		
		test = StringMethods.recursivePalendrome(drome);
		System.out.println(test);
		
	}

}
