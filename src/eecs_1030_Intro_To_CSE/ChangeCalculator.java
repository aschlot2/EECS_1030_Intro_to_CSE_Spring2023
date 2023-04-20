package eecs_1030_Intro_To_CSE;

import java.util.Scanner;
//import java.util.Random;

/**
* @author Alex Schlotterer
* @version 1.0
* 
*/

public class ChangeCalculator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int initalPennies, numPennies = 0, 
				           numNickels = 0, 
				           numDimes = 0, 
				           numQuarters = 0, 
				           numDollars = 0;
		
		// Get the amount of pennies from the user
		System.out.print("Please enter the amount of change you " + 
		                 "need to make (in cents): ");
		initalPennies = scan.nextInt();
		scan.close();
		System.out.println();
		
		// Print "No change" if initalPennies == 0
		if (initalPennies == 0) {
		   System.out.println("No change\n");
		}
		else {
			// Calculate the number of Dollars are in initalPennies
			numDollars = initalPennies / 100;
			numPennies = initalPennies - (numDollars * 100);
			
			// Print the number of Dollars to the screen or 
			// skip if numDollars == 0
			if (numDollars == 0) {
				
			}
			else if (numDollars == 1) {
				System.out.println(numDollars + " Dollar");
			}
			else {
				System.out.println(numDollars + " Dollars");
			}
			
			
			// Calculate the number of Quarters are in numPennies
			numQuarters = numPennies / 25;
			numPennies = numPennies - (numQuarters * 25);
			
			// Print the number of Quarters to the screen or 
			// skip if numQuarters == 0
			if (numQuarters == 0) {
				
			}
			else if (numQuarters == 1) {
				System.out.println(numQuarters + " Quarter");
			}
			else {
				System.out.println(numQuarters + " Quarters");
			}
			
			
			// Calculate the number of Dimes are in numPennies
			numDimes = numPennies / 10;
			numPennies = numPennies - (numDimes * 10);
			
			// Print the number of Dimes to the screen or 
			// skip if numDimes == 0
			if (numDimes == 0) {
				
			}
			else if (numDimes == 1) {
				System.out.println(numDimes + " Dime");
			}
			else {
				System.out.println(numDimes + " Dimes");
			}
			
			
			// Calculate the number of numNickels are in numPennies
			numNickels = numPennies / 5;
			numPennies = numPennies - (numNickels * 5);
			
			// Print the number of Nickels to the screen or 
			// skip if numNickels == 0
			if (numNickels ==0) {
				
			}
			else if (numNickels == 1) {
				System.out.println(numNickels + " Nickel");
			}
			else {
				System.out.println(numNickels + " Nickels");
			}
			
			
			// Print the number of Pennies to the screen or 
			// skip if numPennies == 0
			if (numPennies == 0) {
				
			}
			else if (numPennies == 1) {
				System.out.println(numPennies + " Penny");
			}
			else {
				System.out.println(numPennies + " Pennies");
			}
			
			System.out.println();
		}
		
		System.out.println("End Change Calculator");
		
	}

}
