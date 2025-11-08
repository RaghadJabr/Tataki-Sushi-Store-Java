package FinalProject;

import java.util.Scanner;

public class Tataki {
	public static void main(String[] args) {
		double totalCalories = 0;
		double totalPrice = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Tataki please take a seat so we can take your order");
		System.out.println("What would you like to eat a poke bowl or a sushi roll?");
		String dish = sc.nextLine();
		dish.toLowerCase();
		if (dish.equals("poke bowl") || dish.equals("sushi roll") || dish.equals("sushi") || dish.equals("poke")) {
			System.out.println("That sounds tasty :)\nNow build your " + dish + " with us!!");
			System.out.println("That sounds tasty :)\nNow build your poke bowl/Sushi role with us!!");
			System.out.println("We need the topings. We have variety of options!!");
			System.out.println(
					"Here is the menu for the protine topings:\n1.Crab Sticks\n2.Salmon\n3.Tuna (My personal favourite)\n4.Chicken breasts\n5.Brisket\n6.Skip (I am a vegetarian)");

			// Get the number of protein toppings
			System.out.println("Now choose how many protine topings you want");
			int proteinNum = sc.nextInt();
			sc.nextLine();
			int[] proteinArr = new int[proteinNum];

			if (proteinNum < 0) {
				System.out.println("Invalid input. Please enter a valid number.");
				return;
			} else if (proteinNum == 6) {
				System.out.println("Skipping protein topings");
				proteinNum = 0;
			} else {

				// Loop to get the selected protein toppings and update calories and price
				for (int i = 0; i < proteinNum; i++) {
					try {
						System.out.println("Choose toping number " + (i + 1));
						int proteinOption = sc.nextInt();

						switch (proteinOption) {
						case 1:
							totalCalories += 60;
							totalPrice += 2;
							proteinArr[i] += 60;
							break;
						case 2:
							totalCalories += 100;
							totalPrice += 6;
							proteinArr[i] += 100;
							break;
						case 3:
							totalCalories += 150;
							totalPrice += 6.75;
							proteinArr[i] += 150;
							break;
						case 4:
							totalCalories += 90;
							totalPrice += 7;
							proteinArr[i] += 90;
							break;
						case 5:
							totalCalories += 120;
							totalPrice += 3.5;
							proteinArr[i] += 120;
							break;
						default:
							System.out.println("Invalid dish selection.");
							i--;
							break;
						}

					} catch (Exception e) {
						System.out.println("Invalid input. Please enter a valid number.");
						return;
					}
				}
			}
			
			// Get the number of Extra toppings
			System.out.println("Now we need some color to our dish:)");
			System.out.println(
					"Here is the menu for extra topings:\n1.Cucumber\n2.Carrots\n3.Mangos\n4.Eggs\n5.Caviar\n6.Avocados\n7.Cream cheese\n8.No extra topings");
			System.out.println("Now choose how many extra topings you want");
			int extraNum = sc.nextInt();
			sc.nextLine();// Consume the newline character
			int[] extraArr = new int[extraNum];
			if (extraNum < 0) {
				System.out.println("Invalid input. Please enter a valid number.");
			}
			if (extraNum == 8) {
				System.out.println("Skipping extra topings");
				extraNum = 0;
			} else {
				// Loop to get the selected extra toppings and update calories and price
				for (int i = 0; i < extraNum; i++) {
					try {
						System.out.println("Choose the number of the toping " + (i + 1));
						int extraOption = sc.nextInt();
						switch (extraOption) {
						case 1:
							totalCalories += 5;
							totalPrice += 0.2;
							extraArr[i] += 5;
							break;
						case 2:
							totalCalories += 7;
							totalPrice += 0.35;
							extraArr[i] += 7;
							break;
						case 3:
							totalCalories += 75;
							totalPrice += 2;
							extraArr[i] += 75;
							break;
						case 4:
							totalCalories += 90;
							totalPrice += 1;
							extraArr[i] += 90;
							break;
						case 5:
							totalCalories += 15;
							totalPrice += 5;
							extraArr[i] += 15;
							break;
						case 6:
							totalCalories += 150;
							totalPrice += 3.5;
							extraArr[i] += 150;
							break;
						case 7:
							totalCalories += 200;
							totalPrice += 2.5;
							extraArr[i] += 200;
							break;
						default:
							System.out.println("Invalid dish selection.");
							i--;
							break;
						}
					}

					catch (Exception e) {
						System.out.println("Invalid input. Please enter a valid number.");
						return;
					}
				}
			}
			// Get sauces
			System.out.println("Now to put it all together we need sauce");
			System.out.println(
					"Here is the menu for sauces:\n1.Soy Sauce\n2.Sweet n' Sour\n3.Wasabi\n4.Mayo\n5.No Sauce");
			System.out.println("Now choose how many sauces you want");
			int sauceNum = sc.nextInt();
			sc.nextLine();// Consume the newline character
			int[] sauceArr = new int[sauceNum];

			// Validate the number of sauces
			if (sauceNum < 0) {
				System.out.println("Invalid input. Please enter a valid number.");
				return;
			}

			else if (sauceNum == 5) {
				System.out.println("Skipping sauces");
				sauceNum = 0;
			} else {

				for (int i = 0; i < sauceNum; i++) {
					try {
						System.out.println("Choose the number of the sauce " + (i + 1));
						int sauceOption = sc.nextInt();
						switch (sauceOption) {
						case 1:
							totalCalories += 5;
							totalPrice += 0.2;
							sauceArr[i] += 5;
							break;
						case 2:
							totalCalories += 7;
							totalPrice += 0.35;
							sauceArr[i] += 7;
							break;
						case 3:
							totalCalories += 75;
							totalPrice += 2;
							sauceArr[i] += 75;
							break;
						case 4:
							totalCalories += 90;
							totalPrice += 1;
							sauceArr[i] += 90;
							break;
						default:
							System.out.println("Invalid dish selection.");
							i--;
							break;
						}

					} catch (Exception e) {
						System.out.println("Invalid input. Please enter a valid number.");
						return;
					}
				}
				System.out.println(">>> Order has been placed\nhere is your total: " + totalPrice + "$"
						+ "\n>>>And here is your total calories: " + totalCalories);
				System.out.println(">>> Here is a calories order for each ingredient:");
				totalArr(sauceNum, sauceArr, extraNum, extraArr, proteinNum, proteinArr);

			}
		} else {
			System.out.println("Wrong resturant ;)");
		}

	}

	// Function to merge all ingredient arrays and sort them by calories
	static void totalArr(int sauceNum, int[] sauceArr, int extraNum, int[] extraArr, int proteinNum, int[] proteinArr) {
		int totalSize = sauceNum + extraNum + proteinNum;
		int[] calArr = new int[totalSize];
		for (int i = 0; i < proteinNum; i++) {
			calArr[i] = proteinArr[i];
		}
		int j = 0;
		for (int i = proteinNum; i < proteinNum + extraNum; i++) {
			calArr[i] = extraArr[j];
			j++;
		}
		j = 0;
		for (int i = proteinNum + extraNum; i < totalSize; i++) {
			calArr[i] = sauceArr[j];
			j++;
		}

		bubbleSort(calArr, totalSize);
	}

	// Function to sort an array using bubble sort
	static void bubbleSort(int[] calArr, int totalSize) {
		for (int i = 0; i < totalSize - 1; i++) {
			for (int j = 0; j < totalSize - 1 - i; j++) {
				if (calArr[j] > calArr[j + 1]) {
					int temp = calArr[j];
					calArr[j] = calArr[j + 1];
					calArr[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < totalSize; i++) {
			System.out.print("ingredient number " + (i + 1) + ":" + " " + calArr[i] + "Cal");
			System.out.println();
		}
	}
}
