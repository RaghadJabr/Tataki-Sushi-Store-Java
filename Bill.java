package FinalProjectOOP;

import java.util.ArrayList;

public class Bill {
	public ArrayList <Double> totalPriceList;
	public ArrayList <Integer> totalCaloriesList;

	public Bill() {
		totalPriceList = new ArrayList<>();
		totalCaloriesList = new ArrayList<>();
	}

	public void displayItems() {
		int totalCal = 0;
		double totalPrice = 0;

		for (int i = 0; i < totalPriceList.size(); i++) {
			totalPrice += totalPriceList.get(i);
		}

		for (int i = 0; i < totalCaloriesList.size(); i++) {
			totalCal += totalCaloriesList.get(i);
		}

		for (int i = 0; i < totalCaloriesList.size() - 1; i++) {
			for (int j = 0; j < totalCaloriesList.size() - 1 - i; j++) {
				if (totalCaloriesList.get(j) > totalCaloriesList.get(j + 1)) {
					int temp = totalCaloriesList.get(j);
					totalCaloriesList.set(j, totalCaloriesList.get(j + 1));
					totalCaloriesList.set(j + 1, temp);
				}
			}
		}
		
		//display Bill
		System.out.println(">>> Order has been placed\nhere is your total: " + totalCal);
		
		System.out.println("Here is your total calories: " + totalPrice + " $");
		System.out.println();
		
		System.out.println(">>> Here is a calories order for each ingredient: ");
		System.out.println();

		for (int i = 0; i < totalCaloriesList.size(); i++) {
			System.out.println("calories: " + totalCaloriesList.get(i));
		}
		System.out.println();
	}
	
	//Overloading
	 void setTotalList(Double price) {
		totalPriceList.add(price);
	}

	 void setTotalList(Integer cal) {
		totalCaloriesList.add(cal);
	}

}


