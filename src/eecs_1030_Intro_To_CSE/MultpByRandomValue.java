package eecs_1030_Intro_To_CSE;

import java.util.Scanner;
import java.util.Random;

/** 
 * @author Alex Schlotterer
 * @version 1.0
 *
 */

public class MultpByRandomValue {

	public static void main(String[] args) {
		// Initialize two variables
		double num1, num2;
		
		// Prompt user to enter a value
		System.out.print("Please enter a number: ");
		
		// Gets the user's input and assigns it to  num1
		Scanner scan1 = new Scanner(System.in);
		num1 = scan1.nextDouble();
		scan1.close();
		
		// Add a line to space out the output
		System.out.println();
		
		// Creates a random number and assigns it to num2
		Random randomNum = new Random();
		num2 = randomNum.nextDouble(100);
		
		// Prints a statement showing the randomly generated number
		System.out.println("The random number generated is: " + num2 + "\n");
		
		// Multiples num1 and num2 and shows the result
		System.out.printf("%.2f * %.2f = %.2f\n", num1, num2, (num1 * num2));
		System.out.println();
		
	}

}
