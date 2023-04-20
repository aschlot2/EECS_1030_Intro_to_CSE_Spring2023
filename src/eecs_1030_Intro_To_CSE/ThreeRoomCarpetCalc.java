package eecs_1030_Intro_To_CSE;

import java.util.Scanner;

/**
 * @author Alex Schlotterer
 * @version 1.0
 * 
 */

public class ThreeRoomCarpetCalc {

	public static void main(String[] args) {
		final double laborPricePerSqFt = 0.75,
			     taxRate = 0.07;
		
		int roomWidth1,  roomWidth2,  roomWidth3,
			roomLength1, roomLength2, roomLength3,
			roomSqFt1,   roomSqFt2,   roomSqFt3;
		
		double pricePerSqFt1, pricePerSqFt2, pricePerSqFt3,
			   carpetCost1,   carpetCost2,   carpetCost3,
			   laborCost1,    laborCost2,    laborCost3,
			   salesTax1,     salesTax2,     salesTax3,
			   totalCost1,    totalCost2,    totalCost3;
		
		Scanner scan = new Scanner(System.in);
		
		
		// Get the use's input for order 1
		pricePerSqFt1 = scan.nextDouble();
		roomWidth1 = scan.nextInt();
		roomLength1 = scan.nextInt();
		
		// Get the use's input for order 2
		pricePerSqFt2 = scan.nextDouble();
		roomWidth2 = scan.nextInt();
		roomLength2 = scan.nextInt();
		
		// Get the use's input for order 3
		pricePerSqFt3 = scan.nextDouble();
		roomWidth3 = scan.nextInt();
		roomLength3 = scan.nextInt();
		
		// Close the scanner
		scan.close();
		
		// Order 1
		System.out.println("Order #1");
		roomSqFt1 = Area(roomWidth1, roomLength1);
		carpetCost1 = CarpetCost(pricePerSqFt1, roomSqFt1);
		laborCost1 = LaborCost(laborPricePerSqFt, roomSqFt1);
		salesTax1 = SalesTax(carpetCost1, laborCost1, taxRate);
		totalCost1 = TotalCost(carpetCost1, laborCost1, salesTax1);
		System.out.printf("Cost: $%.2f\n\n", totalCost1);
		
		
		// Order 2
		System.out.println("Order #2");
		roomSqFt2 = Area(roomWidth2, roomLength2);
		carpetCost2 = CarpetCost(pricePerSqFt2, roomSqFt2);
		laborCost2 = LaborCost(laborPricePerSqFt, roomSqFt2);
		salesTax2 = SalesTax(carpetCost2, laborCost2, taxRate);
		totalCost2 = TotalCost(carpetCost2, laborCost2, salesTax2);
		System.out.printf("Cost: $%.2f\n\n", totalCost2);
		
		
		// Order 3
		System.out.println("Order #3");
		roomSqFt3 = Area(roomWidth3, roomLength3);
		carpetCost3 = CarpetCost(pricePerSqFt3, roomSqFt3);
		laborCost3 = LaborCost(laborPricePerSqFt, roomSqFt3);
		salesTax3 = SalesTax(carpetCost3, laborCost3, taxRate);
		totalCost3 = TotalCost(carpetCost3, laborCost3, salesTax3);
		System.out.printf("Cost: $%.2f\n\n", totalCost3);
		
		
		// Calculate and output the total sale
		double totalSales = totalCost1 + totalCost2 + totalCost3;
		System.out.printf("Total Sales: $%.2f\n\n", totalSales);
		
	}
	
	public static int Area(int roomWidth, int roomLength) {
		int roomSqFt;
		
		// Calculate the area of the room 
		roomSqFt = roomWidth * roomLength;
				
		// Output the room's area
		System.out.println("Room: " + roomSqFt + " sq ft");
		
		return roomSqFt;
	}
	
	public static double CarpetCost(double pricePerSqFt, int roomSqFt) {
		double carpetCost;
		
		// Calculate the carpet cost with an additional 20% for 
		// wasted material
		carpetCost = pricePerSqFt * (roomSqFt * 1.20);
		
		// Output the room's area and the carpet's cost
		System.out.printf("Carpet: $%.2f\n", carpetCost);
		
		return carpetCost;
	}
	
	public static double LaborCost(double laborPricePerSqFt, int roomSqFt) {
		double laborCost;
		
		// Calculate the cost of labor ($0.75 per actual sq ft)
		laborCost = roomSqFt * laborPricePerSqFt;
		
		// Output the cost of the installation labor
		System.out.printf("Labor: $%.2f\n", laborCost);
		
		return laborCost;
	}
	
	public static double SalesTax(double carpetCost, 
			                      double laborCost, double taxRate) {
		double salesTax;
		
		// Calculate the sales tax on carpet and labor
		salesTax = (carpetCost + laborCost) * taxRate;
		
		// Output the sales tax
		System.out.printf("Tax: $%.2f\n", salesTax);
		
		return salesTax;
	}
	
	public static double TotalCost(double carpetCost,
			                       double laborCost, double salesTax) {
		double totalCost;
		
		// Calculate the total cost
		totalCost = carpetCost + laborCost + salesTax;
		
		return totalCost;
	}
	
}
