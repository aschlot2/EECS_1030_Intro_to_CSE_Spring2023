package eecs_1030_Intro_To_CSE;

//import java.util.Random;                   // Random rand = new Random();  |  int randInt = rand.nextInt()
import java.util.Scanner;                  // Scanner scan = new Scanner(System.in);  |  scan.close();
//import java.util.InputMismatchException;   // (InputMismatchException e)

/**
* @author Alex Schlotterer
* @version 1.0
* 
*/

public class GroupingIntoRanges {

	public static void main(String[] args) {
		final int run = 2;                                                    // Constant for runs of more than two chapters
		Scanner scan = new Scanner(System.in);                                // Scanner to get the user's input
		int[] chapterSelect = new int[15];                                    // Stores the user's chapter selections
		boolean noChapters = true;                                            // T/F variable to check to see if no chapters were selected
		int startCh = 0, endCh = 0;                                           // Two variables to store the start & end chapters of runs
		
		
		// Stores what chapters the user wants into an array
		System.out.print("Please enter the chapters (1 - 15) " 
				+ "that you wish to purchase\n"
				+ "(Enter \"1\" to select a chapter and \"0\" to not): ");    // User directions
		for (int i = 0; i < chapterSelect.length; i++) {
			chapterSelect[i] = scan.nextInt();                                // Gets the user's input & stores it in the chapters array
		}
		scan.close();                                                         // Closes the scanner
		
		
		// No chapters condition check
		for (int i = 0; i < chapterSelect.length; i++) {
			if (chapterSelect[i] == 1) {                                      // Checks if the chapter has been selected
				noChapters = false;                                           // If true, then noChapters is set to false
			}
		}
		
		
		// Outputs the chapter numbers that the user wants
		if (noChapters) {                                                     // Checks if no chapters were selected
			System.out.println("None ");                                      // If true, outputs "None " 
		}
		else {
			for (int i = 0; i < chapterSelect.length; i++) {                  // Loop to cycle through the chapterSelect array
				if (chapterSelect[i] == 1) {                                  // Checks if the chapter has been selected
					startCh = i;                                              // Initiates the start of the chapter run
					endCh = i;                                                // Initiates the default chapter run ending
					
					int j = i + 1;                                            // While looping index variable "i + 1" for the next chapter's index
					while ( (j < chapterSelect.length)                        // Checks if j is less than the number of chapters
							&& (chapterSelect[j] == 1) ) {                    // Checks if the chapter at index "j" is selected
						endCh = j;                                            // If both true: Sets the end of the chapter run
						j++;                                                  //               Increments "j" for the while loop
					}
					
					startCh++;                                                // Increment startCh to get the actual chapter number
					endCh++;                                                  // Increment endCh to get the actual chapter number
					if ((endCh - startCh) >= run) {                           // Checks if there is a run of 3 or more chapters
						System.out.print(startCh + "-" + endCh + " ");        // If true, outputs the run in the proper format
						i = j;                                                // Makes "i" equal to "j" so the last chapter in the run isn't repeated
					}
					else {
						System.out.print(startCh + " ");                      // Outputs the chapter's number followed by a space
					}
				}
			}
			System.out.println();                                             // Prints a new line for spacing
		}
	}
}       

/*
 *  Test Cases:
 *      {0 0 0 0 0 0 0 0 0 0 0 0 0 0 0} Result Should Be: "None "
 *      {1 1 1 1 1 1 1 1 1 1 1 1 1 1 1} Result Should Be: "1-15 "
 *      {1 1 1 1 0 1 0 1 1 0 1 1 1 0 0} Result Should Be: "1-4 6 8 9 11-13 "
 *      {1 1 1 0 1 1 1 0 1 1 1 0 1 0 1} Result Should Be: "1-3 5-7 9-11 13 15 "
 *      {0 1 1 1 1 1 1 1 1 1 1 1 1 1 0} Result Should Be: "2-14 "
 *      {0 0 0 0 0 0 0 0 1 0 0 0 0 0 0} Result Should Be: "9 "
 *      {1 0 0 0 0 0 0 0 0 0 0 0 0 0 0} Result Should Be: "1 "
 *      {0 0 0 0 0 0 0 0 0 0 0 0 0 0 1} Result Should Be: "15 "
 */