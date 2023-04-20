package eecs_1030_Intro_To_CSE;

import java.util.Scanner;

public class MinMaxAverage {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] inputInts = new int[10];
		int min, max, total = 0;
		double average;
		
		
		// Gets the 10 user input numbers
		for (int i = 0; i < inputInts.length; i++) {
			inputInts[i] = scan.nextInt();
		}
		scan.close();
		
		// Finds the smallest number that the user has entered
		min = inputInts[0];
		for (int i = 0; i < inputInts.length; i++) {
			if (inputInts[i] < min) {
				min = inputInts[i];
			}
		}
		
		// Finds the largest number that the user has entered
		max = inputInts[0];
		for (int i = 0; i < inputInts.length; i++) {
			if (inputInts[i] > max) {
				max = inputInts[i];
			}
		}
		
		// Calculates the average of the numbers that the user has entered
		for (int i = 0; i < inputInts.length; i++) {
			total += inputInts[i];
		}
		average = total / ((double) inputInts.length);
		
		// Displays the results to the output screen
		System.out.println(min + " " + max + " " + average);
	}
}

/*
 * Test Case: Input{1 1 1 1 1 3 3 3 3 3} Expected Output: "1 3 2.0"
 * Test Case: Input{9 8 7 6 5 4 3 2 1 0} Expected Output: "0 9 4.5"
 * Test Case: Input{1 1 1 1 1 3 3 3 3 3} Expected Output: "1 3 2.0"
 * Test Case: Input{9 8 7 6 5 4 3 2 1 0} Expected Output: "0 9 4.5"
 * Test Case: Input{-2 -4 -6 -8 -10 -12 -14 -16 -18 -20} Expected Output: "-20 -2 -11.0"
*/
