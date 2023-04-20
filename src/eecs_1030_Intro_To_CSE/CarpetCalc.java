package eecs_1030_Intro_To_CSE;

import java.util.Scanner;

/**
 * @author Alex Schlotterer
 * @version 1.0
 * 
 * 
 */

public class CarpetCalc {

	public static void main(String[] args) {
		// Create the scanner to read the user's input
		Scanner scan = new Scanner(System.in);
		
		
		// Get the number of rooms that need carpet
		System.out.print("Please enter the number of rooms: ");
		int rooms = scan.nextInt();
		System.out.println();
		
		// Set constants 
		final double laborPricePerSqFt = 0.75,
			     	 taxRate = 0.07;
		
		
		// Initiate user input arrays
		double[] pricePerSqFt = new double [rooms];
		
		int[] roomWidth = new int [rooms],
			  roomLength = new int [rooms];
		
		
		// Initiate calculated values arrays
		int[] roomSqFt = new int [rooms];
		
		double[] carpetCost = new double [rooms],
			     laborCost = new double [rooms],
			     salesTax = new double [rooms],
			     totalCost = new double [rooms];
		
		
		// Initiate totalSales
		double totalSales = 0.0;
		
		
		//----------End Defined Variables/Arrays-----------
		
		
		// Reads the user inputs and assigns the values
		// to the proper user input array
		for (int i = 0; i < rooms; i++) {
			pricePerSqFt[i] = scan.nextDouble();
			roomWidth[i] = scan.nextInt();
			roomLength[i] = scan.nextInt();
		}
		
		
		// Close the scanner
		scan.close();
		System.out.println();
		
		
		// Goes through the user input arrays and calculates all 
		// the necessary values and stores them in their proper
		// array
		for (int i = 0; i < rooms; i++) {
			System.out.println("Order #" + (i + 1) );
			roomSqFt[i] = Area(roomWidth[i], roomLength[i]);
			carpetCost[i] = CarpetCost(pricePerSqFt[i], roomSqFt[i]);
			laborCost[i] = LaborCost(laborPricePerSqFt, roomSqFt[i]);
			salesTax[i] = SalesTax(carpetCost[i], laborCost[i], taxRate);
			totalCost[i] = TotalCost(carpetCost[i], laborCost[i], salesTax[i]);
			totalSales = totalSales + totalCost[i];
			System.out.printf("Cost: $%.2f\n\n", totalCost[i]);
		}
		
		
		// Prints the totalSales to output
		System.out.printf("Total Sales: $%.2f\n", totalSales);
		
	}
	
	
	// Calculates the area of the room for one order
	public static int Area(int roomWidth, int roomLength) {
		int roomSqFt;
		
		// Calculate the area of the room 
		roomSqFt = roomWidth * roomLength;
				
		// Output the room's area
		System.out.println("Room: " + roomSqFt + " sq ft");
		
		return roomSqFt;
	}
	
	
	// Calculates the cost of the carpet for one order
	public static double CarpetCost(double pricePerSqFt, int roomSqFt) {
		double carpetCost;
		
		// Calculate the carpet cost with an additional 20% for 
		// wasted material
		carpetCost = pricePerSqFt * (roomSqFt * 1.20);
		
		// Output the room's area and the carpet's cost
		System.out.printf("Carpet: $%.2f\n", carpetCost);
		
		return carpetCost;
	}
	
	
	// Calculates the cost of labor for one order
	public static double LaborCost(double laborPricePerSqFt, int roomSqFt) {
		double laborCost;
		
		// Calculate the cost of labor ($0.75 per actual sq ft)
		laborCost = roomSqFt * laborPricePerSqFt;
		
		// Output the cost of the installation labor
		System.out.printf("Labor: $%.2f\n", laborCost);
		
		return laborCost;
	}
	
	
	// Calculates the sales tax for one order
	public static double SalesTax(double carpetCost, 
			                      double laborCost, double taxRate) {
		double salesTax;
		
		// Calculate the sales tax on carpet and labor
		salesTax = (carpetCost + laborCost) * taxRate;
		
		// Output the sales tax
		System.out.printf("Tax: $%.2f\n", salesTax);
		
		return salesTax;
	}
	
	
	// Calculates the total cost of the carpet, labor, and 
	// sales tax for an order
	public static double TotalCost(double carpetCost,
			                       double laborCost, double salesTax) {
		double totalCost;
		
		// Calculate the total cost
		totalCost = carpetCost + laborCost + salesTax;
		
		return totalCost;
	}

}
