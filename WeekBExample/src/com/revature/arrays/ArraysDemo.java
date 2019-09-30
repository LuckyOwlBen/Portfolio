package com.revature.arrays;

public class ArraysDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create a 2D array of ints
		int[][] arr1 = new int[10][20];

		// really creating an array of arrays
		int[][] arr2 = { { 12, 21, 14 }, { 31, 16, 25 } };
		int[][] sortedArray = new int[3][3];
		int bigNumber;
		int runningTotal;

		/*
		 * for(int i = 0; i < arr2.length; i++) { for(int j = 0; j < arr2[i].length;
		 * j++) { System.out.println("j ="+i); System.out.println("j = "+j);
		 * System.out.println("arr2[i][j] "+arr2[i][j]); }
		 */
		// bigNumber = largestElement(arr2);
		// System.out.println(bigNumber);

		// runningTotal = sumElements(arr2);
		// System.out.println(runningTotal);

		sortedArray = sortArray(arr2);
		for (int i = 0; i < sortedArray.length; i++) {
			for (int j = 0; j < sortedArray[i].length; j++) {
				System.out.println(sortedArray[i][j]);
			}

		}
	}

	// returns largest element in array
	public static int largestElement(int[][] arr) {
		int biggestNumber = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (biggestNumber < arr[i][j]) {
					biggestNumber = arr[i][j];
				}
			}
		}
		return biggestNumber;
	}

	// return the sum of all elements in the provided array
	public static int sumElements(int[][] arr) {

		int runningTotal = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				runningTotal = runningTotal + arr[i][j];
			}
		}
		return runningTotal;
	}

	// sort provided array from top left to bottom right
	public static int[][] sortArray(int[][] arr) {

		int length = arr.length;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				for (int k = 0; k < arr[i].length - i; k++) {
					if (arr[i][j] < arr[i][k]) {
						int temp = arr[i][j];
						arr[i][j] = arr[i][k];
						arr[i][k] = temp;
					}						
					
					if(arr[0][length] > arr[1][0]){
						int temp = arr[0][length];
						arr[0][length] = arr[1][0];
						arr[1][0] = temp;
					}
				}
			}
		}
		return arr;
	}
}
