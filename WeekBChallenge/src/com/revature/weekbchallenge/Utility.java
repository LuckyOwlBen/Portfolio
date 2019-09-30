package com.revature.weekbchallenge;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Utility {

	static ArrayList<String> bank = new ArrayList<String>();
	static File file = new File("bank.txt");
	//static FileInputStream fs = new FileInputStream("bank.txt");

	private String start;
	private String end;

	public static int mutationCount(String start, String end) {

		int numMutations = 0;
		for (int index = 0; index < start.length(); index++) {

			char s;
			char e;

			s = start.charAt(index);
			e = end.charAt(index);

			if (s != e) {
				numMutations++;
			}
		}
		return numMutations;
	}

	public static boolean geneChecker(String userInput) {

		userInput = userInput.toLowerCase();

		if (userInput.length() != 8) {
			System.out.println("Gene strings must be 8 characters long try again");
			return false;
		}
		for (int i = 0; i < userInput.length(); i++) {
			char c;
			c = userInput.charAt(i);
			if (c != 'a') {
				if (c != 'c') {
					if (c != 'g') {
						if (c != 't') {
							System.out.println("Gene strings must be an A, C, G or T");
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public void userInput() {

		boolean sTest = false;
		boolean eTest = false;

		int totalMutations;

		String start;
		String end;

		Scanner sc = new Scanner(System.in);

		// System.out.println("Input the gene bank");

		System.out.println("Input the original gene string ");

		while (sTest != true) {
			start = sc.next();
			sTest = Utility.geneChecker(start);
			if (sTest == true) {
				this.start = start;
			}
		}

		System.out.println("Input the end gene string");
		while (eTest != true) {
			end = sc.next();
			eTest = Utility.geneChecker(end);
			if (eTest == true) {
				this.end = end;
			}
		}

		totalMutations = Utility.mutationCount(this.start, this.end);

		System.out.println(totalMutations);

		sc.close();
	}

	public void populateBank(String input) {

		bank.add(input);
	}

	public static int mutationCheck(String start, String end) {

		int mutation = 0;

		if (!bank.contains(end)) {
			System.out.println("End result is not a valid gene type");
			return -1;
		}

		if (start.equals(end)) {
			return mutation;
		}

		for (int i = 0; i < start.length(); i++) {
			if (end.charAt(i) != start.charAt(i)) {
				start.replace(start.charAt(i), end.charAt(i));

				if (!bank.contains(start)) {
					System.out.println("Mutation was an invalid gene type");
					return 0;
				}
				mutation++;
			}
		}
		return mutation;
	}

	/*public static void fileStream() {
		System.out.println(fs.getAbsolutePath());
		fs.
		
	}*/
}
