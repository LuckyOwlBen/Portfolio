package com.revature.strings;

import java.util.Arrays;

public class StringMethods {

	public static String reversal(String string) {

		char[] dArray = new char[string.length()];
		char[] cArray = new char[string.length()];

		cArray = string.toCharArray();

		for (int i = 0; i < cArray.length; i++) {

			if (i == 0) {
				dArray[i] = cArray[cArray.length - 1];
			} else {
				dArray[i] = cArray[cArray.length - i - 1];
			}
		}

		string = String.valueOf(dArray);

		return string;

	}

	public static boolean palendrome(String string) {

		boolean test = false;

		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == string.charAt(string.length() - i - 1)) {
				if (i == string.length() - i - 1) {
					test = true;
				}
			} else {
				test = false;
			}

		}
		return test;
	}

	public static String recursiveReversal(String string) {
		
		char[] arr1 = string.toCharArray();
		
		if(string.length() == 1) {
			return string;
		}
		
		//stores the last letter then makes a copy of the array with one less value and calls it self recursively
		return string.charAt(string.length() -1) + recursiveReversal(String.copyValueOf(Arrays.copyOf(arr1, string.length()-1)));		
	}

	public static boolean recursivePalendrome(String string) {
		
		char[] arr1 = string.toCharArray();
		
		int length = string.length();
		
		if(length == 1 || length == 0) {
			return true;
		}
		
		//creates a copy of the string array with one less index then calls itself recursively
		if(arr1[0] == arr1[length -1 ]) {
			return recursivePalendrome(String.copyValueOf(Arrays.copyOfRange(arr1,1,length-1)));
		}
		else
			return false;
		}
}
