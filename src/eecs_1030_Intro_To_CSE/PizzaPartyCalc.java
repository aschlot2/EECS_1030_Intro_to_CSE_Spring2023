package eecs_1030_Intro_To_CSE;

import java.util.Scanner;

/**
* @author Alex Schlotterer
* @version 1.0
* 
*/

public class PizzaPartyCalc {

	public static void main(String[] args) {
		// Constant
		final double taxRate = 0.07;


		// Variable to change the sizes of the arrays
		int numDays = 3;


		// Initialize user input arrays
		int [] people = new int [numDays];

		double [] sclicesPerPerson = new double [numDays],
				pizzaPrice = new double [numDays];


		// Initialize calculated values arrays
		int [] numPizzas = new int [numDays];

		double [] pizzaCost = new double [numDays],
				salesTax = new double [numDays],
				deliveryFee = new double [numDays],
				total = new double [numDays];

		double weekendTotal = 0;


		// Create a scanner for user inputs
		Scanner scan = new Scanner(System.in);


		//------------End Defined Variables/Arrays-------------


		// Loop to scan and assign values to user input arrays
		for (int i = 0; i < people.length; i++) {
			people[i] = scan.nextInt();
			sclicesPerPerson[i] = scan.nextDouble();
			pizzaPrice[i] = scan.nextDouble();
		}

		// Close the scanner
		scan.close();


		// Loop to calculate the cost of the day
		for (int i = 0; i < people.length; i++) {
			numPizzas[i] = NumPizzas(sclicesPerPerson[i], people[i]);
			pizzaCost[i] = PizzaCost(pizzaPrice[i], numPizzas[i]);
			salesTax[i] = SalesTax(taxRate, pizzaCost[i]);
			deliveryFee[i] = DeliveryFee(pizzaCost[i], salesTax[i]);
			total[i] = Total(pizzaCost[i], salesTax[i], deliveryFee[i]);
			weekendTotal = weekendTotal + total[i];
		}


		// Prints the text output
		for (int i = 0; i < people.length; i++) {
			// Prints the day of the weekend
			switch (i) {
			case 0:
				System.out.println("Friday Night Party");
				break;

			case 1:
				System.out.println("Saturday Night Party");
				break;

			case 2:
				System.out.println("Sunday Night Party");
				break;
			}
			
			// Prints the calculated values
			System.out.print(numPizzas[i]);
			System.out.printf(" Pizzas: $%.2f\n", pizzaCost[i]);
			System.out.printf("Tax: $%.2f\n", salesTax[i]);
			System.out.printf("Delivery: $%.2f\n", deliveryFee[i]);
			System.out.printf("Total: $%.2f\n\n", total[i]);
		}


		// Print the total cost of hosting
		System.out.printf("Weekend Total: $%.2f\n", weekendTotal);

	}


	// Determines the number of pizzas for the party
	public static int NumPizzas(double slicesPerPerson, int numPeople) {
		int numPizzas = 0;

		numPizzas = (int) Math.ceil( ( (slicesPerPerson * numPeople) / 8.0 ) );

		return numPizzas;
	}

	// Calculates the cost of the pizza
	public static double PizzaCost(double pizzaPrice, int numPizzas) {
		double pizzaCost = 0.0;

		pizzaCost = pizzaPrice * numPizzas;

		return pizzaCost;
	}


	// Calculates the sales tax
	public static double SalesTax(double taxRate, double pizzaCost) {
		double salesTax = 0;

		salesTax = pizzaCost * taxRate;

		return salesTax;
	}


	// Calculates the delivery fee (20% of cost + sales tax)
	public static double DeliveryFee(double pizzaCost, double salesTax) {
		final double deliveryRate = 0.20;
		double deliveryFee = 0;

		deliveryFee = (pizzaCost + salesTax) * deliveryRate;

		return deliveryFee;
	}


	// Calculates the day's total cost
	public static double Total(double pizzaCost, 
			double salesTax, double deliveryFee) {
		double total = 0;

		total = pizzaCost + salesTax + deliveryFee;

		return total;
	}

}
