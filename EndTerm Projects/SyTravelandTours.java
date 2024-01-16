import java.util.*;
public class SyTravelandTours {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		String[] destinations = {
				"Juliens Wreck, Sipalay City",
        "Suyak Island, Sagay City",
        "Mag-aso Falls, Kabankalan City",
        "Buenos Aires Mountain Resort, Bago City",
        "Manjuyod White Sandbar, Bais City",
        "Lakawon Island, Cadiz City",
        "Kennington Hill Nature Park, Municipality of Candoni",
        "Danjugan Island Marine Reserve and Sanctuaries, Cauayan City",
        "Nabulao Beach and Dive Resort, Sitio Totong, Brgy. Talacagay, Hinoba-an",
        "Campuestohan Highland Resort, Talisay City"
		};
		
		double[] distances = {163, 99.4, 107, 39, 174, 67, 137, 150, 183, 23};
		String[] directions = {"S", "N", "S", "S", "S", "N", "S", "S", "S", "N"};
		
		System.out.println("Destinations: ");
  	for (int j = 0; j < destinations.length; j++) {
  		System.out.println((j + 1) + ". " + destinations[j]);
  	}
  	System.out.println("\nChoose only five [5] destinations.");
		
		int[] selectedDestinations = new int[5];
		int counter = 0, pickedDestination = 0;
			
		do {
			for (int j = 0; j < selectedDestinations.length; j++) {
				System.out.print("Choose destination " + (j + 1) + ": ");
				pickedDestination = scan.nextInt();
				if (pickedDestination >= 1 && pickedDestination <= destinations.length) {
					boolean alreadySelected = false;
					
					for (int i = 0; i < selectedDestinations.length; i++) {
						if (selectedDestinations[i] == pickedDestination - 1) {
							alreadySelected = true;
							break;
						}
					}

					if (!alreadySelected) {
						selectedDestinations[j] = pickedDestination - 1;
						counter++;
					} else {
						System.out.println("\nDestination " + pickedDestination + " has already been selected. Please choose a different one.\n");
						j--;
					}
				} else {
					System.err.println("\nINVALID ENTRY.\nPlease choose a number between 1 and " + destinations.length + "\n");
					j--;
				}
			}
		} while (counter < selectedDestinations.length);
		
		double totalDistance = totalDist(distances, directions, selectedDestinations);
		
		String[] vehicles = { "Toyota Hi Ace", "Mitsubishi L300", "Suzuki APV", "Foton Transvan",
													"Nissan Vanette", "Mazda MPV", "Hyundai H-1" };
		double[] fuelConsumptions = { 8.0, 9.0, 8.9, 10.0, 8.5, 8.6, 7.6 };
		double[] rentalFees = { 3000, 3600, 4000, 4400, 3000, 3600, 3200 };
		
		double deposit = 15000;
		double driverFee = 0;
		
		System.out.println();
		for (int j = 0; j < vehicles.length; j++) {
			System.out.println((j + 1) + ". " + vehicles[j]);
		}
		
		System.out.print("Choose A Vehicle: ");
		int chosenVehicle = scan.nextInt(); 
		scan.nextLine();
		System.out.println();
		
		System.out.println("Do you want to hire a personal driver? ");
		System.out.println(" [1] - YES\n [2] - NO");
		System.out.print("Answer: ");
		int hireDriver = scan.nextInt();
		System.out.println();
		
		if (hireDriver == 1) {
			driverFee = 2000;
		}
		
		System.out.print("Enter the number of days of travel: ");
		int numOfDays = scan.nextInt();
		System.out.println();
		
		System.out.print("Fuel Price Per Liter: ₱ ");
 		double fuelPrice = scan.nextDouble(); 
 		System.out.println();
 		
 		double totalFuelConsumption = (fuelConsumptions[chosenVehicle - 1] / 100) * totalDistance;
 		double totalFuelCost = totalFuelConsumption * fuelPrice;
 		double totalRentalCost = rentalFees[chosenVehicle - 1] * numOfDays;
 		double insuranceCost =  totalRentalCost * 0.13;
 		double studentsAllowance = (300 * 10) * numOfDays;
 		double totalExpenses = deposit + (driverFee * numOfDays) + totalFuelCost + totalRentalCost + insuranceCost;
 		double contribution = (totalExpenses - studentsAllowance) / 10;
 		double remainingAmount = totalExpenses - deposit - studentsAllowance;
		
		totalDist(distances, directions, selectedDestinations);
		System.out.printf("Total Distance Travelled: %,.2f kilometers%n", totalDistance );
		System.out.printf("Total Fuel Consumption: %,.2f Liters%n", totalFuelConsumption);
		System.out.printf("Total Fuel Cost For The Whole Trip: ₱ %,.2f%n", totalFuelCost);
		System.out.printf("Total Rental Cost For The Whole Trip: ₱ %,.2f%n", totalRentalCost);
		System.out.printf("Insurance Cost: ₱ %,.2f%n", insuranceCost);
		System.out.printf("Students Allowance For The Whole Trip: ₱ %,.2f%n", studentsAllowance);
		System.out.printf("Contribution of Each Student:  ₱ %,.2f%n", contribution);
		System.out.printf("Total Expenses For The Whole Trip: ₱ %,.2f%n", totalExpenses);
		System.out.printf("Remaining Amount to Pay: ₱ %,.2f%n", remainingAmount);
	}
	
	public static double totalDist(double[] distances, String[] directions, int[] selectedDestination) {
		double totalDistance = 0;
		totalDistance += distances[(selectedDestination[0])];
		
		for (int j = 1; j < selectedDestination.length; j++) {
				
				String currentDestination = directions[(selectedDestination[j])];
				String previousDestination = directions[(selectedDestination[j - 1])];
				
				double currentDistance = distances[(selectedDestination[j])];
				double previousDistance = distances[(selectedDestination[j - 1])];
				
				if (previousDestination == currentDestination) {
					
					if (previousDistance < currentDistance) {
						totalDistance += (currentDistance - previousDistance);
					} else {
						totalDistance += (previousDistance - currentDistance);
					}
					
				} else {
					totalDistance += (previousDistance + currentDistance);
				}
				
			}
			
			totalDistance += distances[(selectedDestination[4])];
			return totalDistance;
	}
	
}

/*
 * SILDORA, JEGRICK A.
 * PRADO, JHONA MAE O.
 * SUDAYON, KARYL ANN D.
 * GARGARITA, TRISHA FAITH C.
 * MOGAT, ELA MAE T.
 */
