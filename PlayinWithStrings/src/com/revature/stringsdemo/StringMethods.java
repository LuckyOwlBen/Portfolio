package com.revature.stringsdemo;

public class StringMethods {

	public static void main(String[] args) {
		String string = "adam,ben,solange,patrick,sam,jim,sue,berry,jill,";
		String s2;
		String s3;
		
		System.out.println(string);
		//Creates a series of sub strings that split at every delimited character
		String[] s4 = string.split(",", 5);
		
		//makes a smaller word out of a bigger word
		s2 = string.substring(9);
		System.out.println(s2);
		
		//makes all characters in a string uppercase
		s3 = s2.toUpperCase();
		System.out.println(s3);
		
		for(String a: s4) {
			System.out.println(a);
		}
		
	}

}
