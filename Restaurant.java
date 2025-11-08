package FinalProjectOOP;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Restaurant {
	ArrayList<Protein> proteinOptions = new ArrayList<Protein>();
	ArrayList<Extra> extraOptions = new ArrayList<Extra>();
	ArrayList<Sauce> sauceOptions = new ArrayList<Sauce>();
	Bill receipt = new Bill();

	// TODO Auto-generated constructor stub
	public void takeOrder() {
		Scanner choice = new Scanner(System.in);

		System.out.println("Welcome to Tataki, please take a seat so we can take your order.");
		System.out.println("What would you like to eat, a poke bowl or a sushi roll?");
		String dish = choice.nextLine().toLowerCase();

		if (dish.equals("poke bowl") || dish.equals("sushi roll") || dish.equals("sushi") || dish.equals("poke")) {
			System.out.println("That sounds tasty :)\nNow build your " + dish + " with us!!");
			System.out.println("We have a variety of options for toppings!");
		} else {
			System.out.println("Sorry, we don't have " + dish + " on our menu.");
		}
	}

	public void protienOptions() {
		Protein tuna = new Protein("tuna", 5, 6.75, 1);
		Protein salmon = new Protein("Salmon", 10, 8.50, 2);
		Protein chickenBreast = new Protein("Chicken", 7, 7.25, 3);
		Protein brisket = new Protein("Brisket", 8, 9.00, 4);
		Protein crab = new Protein("Crab Sticks", 6, 5.99, 5);
		proteinOptions.add(tuna);
		proteinOptions.add(salmon);
		proteinOptions.add(chickenBreast);
		proteinOptions.add(brisket);
		proteinOptions.add(crab);
	}

	public void extraOptions() {
		Extra cucumber = new Extra("Cucumber", 2, 1.50, 1);
		Extra carrots = new Extra("Carrots", 3, 1.25, 2);
		Extra mangos = new Extra("Mangos", 20, 3.00, 3);
		Extra eggs = new Extra("Eggs", 15, 2.50, 3);
		Extra caviar = new Extra("Caviar", 30, 5.99, 4);
		Extra avocados = new Extra("Avocados", 25, 4.50, 5);
		Extra creamCheese = new Extra("Cream Cheese", 10, 2.00, 6);
		extraOptions.add(cucumber);
		extraOptions.add(carrots);
		extraOptions.add(mangos);
		extraOptions.add(eggs);
		extraOptions.add(caviar);
		extraOptions.add(avocados);
		extraOptions.add(creamCheese);
	}

	public void sauceOptions() {
		Sauce soy = new Sauce("Soy Sauce", 5, 0.50, 1);
		Sauce sweetNSour = new Sauce("Sweet n' Sour", 7, 0.75, 2);
		Sauce wasabi = new Sauce("Wasabi", 10, 0.60, 3);
		Sauce mayo = new Sauce("Mayo", 8, 0.70, 4);
		sauceOptions.add(soy);
		sauceOptions.add(sweetNSour);
		sauceOptions.add(wasabi);
		sauceOptions.add(mayo);
	}

	public void startOrder() {
		Scanner sc = new Scanner(System.in);
		System.out.println(

				"Here is the menu for the protine topings:\n1.Crab Sticks\n2.Salmon\n3.Tuna (My personal favourite)\n4.Chicken breasts\n5.Brisket\n6.Skip (I am a vegetarian)");
		try {
			System.out.println("Now choose how many protine topings you want");

			int proteinNum = sc.nextInt();
			sc.nextLine();
			if (proteinNum == 6) {
				System.out.println("Skipping protein topings");
			} else {
				protienOptions();
				for (int i = 0; i < proteinNum; i++) {
					System.out.println("Choose toping number " + (i + 1));
					int proteinOption = sc.nextInt();

					for (int j = 0; j < proteinOptions.size(); j++) {
						double price = 0;
						int cal = 0;
						if (proteinOption == proteinOptions.get(j).order) {

							price = proteinOptions.get(j).price;
							cal = proteinOptions.get(j).cal;

							receipt.setTotalList(price);
							receipt.setTotalList(cal);
						}
					}
				}
			}
		} catch (InputMismatchException e) {

			System.out.println("Invalid input. Please enter a number.");		}

		try {
			System.out.println("Now we need some color to our dish:)");
			System.out.println(
					"Here is the menu for extra topings:\n1.Cucumber\n2.Carrots\n3.Mangos\n4.Eggs\n5.Caviar\n6.Avocados\n7.Cream cheese\n8.No extra topings");
			System.out.println("Now choose how many extra topings you want");
			int extraNum = sc.nextInt();
			sc.nextLine();
			if (extraNum == 8) {
				System.out.println("Skipping extra topings");

			} else {
				extraOptions();
				for (int i = 0; i < extraNum; i++) {
					System.out.println("Choose toping number " + (i + 1));

					int extraOption = sc.nextInt();
					for (int j = 0; j < extraOptions.size(); j++) {
						double price = 0;
						int cal = 0;
						if (extraOption == extraOptions.get(j).getOrder()) { 

							price = extraOptions.get(j).getPrice();
							cal = extraOptions.get(j).getCalories(); 

							receipt.setTotalList(price);
							receipt.setTotalList(cal);
						}
					}
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a number.");
		}

		try {
			System.out.println("Now to put it all together we need sauce");
			System.out.println(
					"Here is the menu for sauces:\n1.Soy Sauce\n2.Sweet n' Sour\n3.Wasabi\n4.Mayo\n5.No Sauce");
			System.out.println("Now choose how many sauces you want");
			Sauce obj = new Sauce();
			int sauceNum = sc.nextInt();
			sc.nextLine();
			if (sauceNum == 5) {
				obj.message(sauceNum);
				System.out.println("Skipping sauces");
			} else {
				sauceOptions();
				for (int i = 0; i < sauceNum; i++) {
					System.out.println("Choose the number of the sauce " + (i + 1));
					int sauceOption = sc.nextInt();
					obj.message(sauceOption);
					for (int j = 0; j < sauceOptions.size(); j++) {
						double price = 0;
						int cal = 0;
						if (sauceOption == sauceOptions.get(j).order) {
							price = sauceOptions.get(j).price;
							cal = sauceOptions.get(j).cal;

							receipt.setTotalList(price);
							receipt.setTotalList(cal);
						}
					}
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a number.");
		}
	}

	public void endOrder() {
		receipt.displayItems();
	}
}
