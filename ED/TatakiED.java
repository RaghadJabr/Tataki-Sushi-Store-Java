package FinalProjectEventdriven;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TatakiED {
	// Variables to store total calories and total price
    static double totalCalories = 0;
    static double totalPrice = 0;
    
 // Arrays to store checkboxes different ingredients
    static JCheckBox[] proteinCheckBoxes, extraCheckBoxes, sauceCheckBoxes;

    public static void main(String[] args) {
    	// Creating welcome frame
        JFrame welcomeFrame = new JFrame("Welcome to Tataki");
        welcomeFrame.setSize(400, 200);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setLayout(new BorderLayout());

      // Label to print welcoming message
        JLabel welcomeLabel = new JLabel("Welcome to Tataki! Please take a seat so we can take your order.", JLabel.CENTER);
        welcomeFrame.add(welcomeLabel, BorderLayout.NORTH);

        // Buttons to order
        JButton pokeButton = new JButton("Poke Bowl");
        JButton sushiButton = new JButton("Sushi Roll");
        
        welcomeFrame.add(pokeButton, BorderLayout.WEST);
        welcomeFrame.add(sushiButton, BorderLayout.EAST);
        
         // Action listeners for the buttons
        pokeButton.addActionListener(e -> openIngredientsFrame("poke bowl", welcomeFrame)); // this e -> is to go for the other frame when the button is clicked
        sushiButton.addActionListener(e -> openIngredientsFrame("sushi roll", welcomeFrame));

     // Key listener 
        welcomeFrame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    openIngredientsFrame("poke bowl", welcomeFrame);
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    openIngredientsFrame("sushi roll", welcomeFrame);
                }
            }
        });
        
        welcomeFrame.setFocusable(true);
        welcomeFrame.setVisible(true);
    }
    // Method to open ingredients frame
    static void openIngredientsFrame(String dish, JFrame previousFrame) {
    	// Creating ingredients frame
    	JFrame ingredientsFrame = new JFrame("Build Your " + dish);
        ingredientsFrame.setSize(600, 400);
        ingredientsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ingredientsFrame.setLocationRelativeTo(null);
        ingredientsFrame.setLayout(new GridLayout(4, 1));

        JLabel buildLabel = new JLabel("Build your " + dish + " with us!!", JLabel.CENTER);
        ingredientsFrame.add(buildLabel);

        //protein options checkboxes 
        String[] proteinOptions = { "Crab Sticks", "Salmon", "Tuna", "Chicken Breasts", "Brisket" };
        proteinCheckBoxes = new JCheckBox[proteinOptions.length];
        for (int i = 0; i < proteinOptions.length; i++) {
            proteinCheckBoxes[i] = new JCheckBox(proteinOptions[i]);
            ingredientsFrame.add(proteinCheckBoxes[i]);
        }

        //extra options checkboxes 
        String[] extraOptions = { "Cucumber", "Carrots", "Mangos", "Eggs", "Caviar", "Avocados", "Cream Cheese" };
        extraCheckBoxes = new JCheckBox[extraOptions.length];
        for (int i = 0; i < extraOptions.length; i++) {
            extraCheckBoxes[i] = new JCheckBox(extraOptions[i]);
            ingredientsFrame.add(extraCheckBoxes[i]);
        }

        //sauces options checkboxes 
        String[] sauceOptions = { "Soy Sauce", "Sweet n' Sour", "Wasabi", "Mayo" };
        sauceCheckBoxes = new JCheckBox[sauceOptions.length];
        for (int i = 0; i < sauceOptions.length; i++) {
            sauceCheckBoxes[i] = new JCheckBox(sauceOptions[i]);
            ingredientsFrame.add(sauceCheckBoxes[i]);
        }

        // Mousemotion listener to display mouse axis by getPoint()
        ingredientsFrame.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                System.out.println("Mouse moved at: " + e.getPoint());
            }
        });

        JButton submitButton = new JButton("Submit Order");
        ingredientsFrame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
                openBillFrame();
                ingredientsFrame.dispose();
            }
        });

        ingredientsFrame.setVisible(true);
        previousFrame.dispose();
    }

     // Method to calculate total calories and price
    static void calculateTotal() {
        totalCalories = 0;
        totalPrice = 0;

     // Calculating calories and price for protien
        for (JCheckBox checkBox : proteinCheckBoxes) {
            if (checkBox.isSelected()) {
                addProtein(checkBox.getText());
            }
        }

        // Calculating calories and price for extras
        for (JCheckBox checkBox : extraCheckBoxes) {
            if (checkBox.isSelected()) {
                addExtra(checkBox.getText());
            }
        }

        // Calculating calories and price for sauces
        for (JCheckBox checkBox : sauceCheckBoxes) {
            if (checkBox.isSelected()) {
                addSauce(checkBox.getText());
            }
        }
    }

    // Method to add calories and price for selected protein
    private static void addProtein(String option) {
        switch (option) {
            case "Crab Sticks":
                totalCalories += 60;
                totalPrice += 2;
                break;
            case "Salmon":
                totalCalories += 100;
                totalPrice += 6;
                break;
            case "Tuna":
                totalCalories += 150;
                totalPrice += 6.75;
                break;
            case "Chicken Breasts":
                totalCalories += 90;
                totalPrice += 7;
                break;
            case "Brisket":
                totalCalories += 120;
                totalPrice += 3.5;
                break;
            
        }
    }

    private static void addExtra(String option) {
        switch (option) {
            case "Cucumber":
                totalCalories += 5;
                totalPrice += 0.2;
                break;
            case "Carrots":
                totalCalories += 7;
                totalPrice += 0.35;
                break;
            case "Mangos":
                totalCalories += 75;
                totalPrice += 2;
                break;
            case "Eggs":
                totalCalories += 90;
                totalPrice += 1;
                break;
            case "Caviar":
                totalCalories += 15;
                totalPrice += 5;
                break;
            case "Avocados":
                totalCalories += 150;
                totalPrice += 3.5;
                break;
            case "Cream Cheese":
                totalCalories += 200;
                totalPrice += 2.5;
                break;
            
        }
    }

    // Method to open the frame displaying the bill
    private static void addSauce(String option) {
        switch (option) {
            case "Soy Sauce":
                totalCalories += 5;
                totalPrice += 0.2;
                break;
            case "Sweet n' Sour":
                totalCalories += 7;
                totalPrice += 0.35;
                break;
            case "Wasabi":
                totalCalories += 75;
                totalPrice += 2;
                break;
            case "Mayo":
                totalCalories += 90;
                totalPrice += 1;
                break;
            
        }
    }
    private static void openBillFrame() {
        JFrame billFrame = new JFrame("Your Bill");
        billFrame.setSize(400, 300);
        billFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        billFrame.setLayout(new BorderLayout());

        StringBuilder bill = new StringBuilder();
        bill.append(">>> Order has been placed\n").append("Here is your total: $").append(totalPrice).append("\n")
                .append(">>> And here is your total calories: ").append(totalCalories).append("\n")
                .append(">>> Here is a calorie order for each ingredient:\n");

        int[] calArr = getCalorieArray();

        bubbleSort(calArr);

        for (int i = 0; i < calArr.length; i++) {
            bill.append("Ingredient number ").append(i + 1).append(": ").append(calArr[i]).append(" Cal\n");
        }

        JTextArea billArea = new JTextArea(bill.toString());
        billArea.setEditable(false);
        billFrame.add(new JScrollPane(billArea), BorderLayout.CENTER);

        billFrame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    billFrame.dispose();
                }
            }
        });
        billFrame.setFocusable(true);
        billFrame.setVisible(true);
    }
   

    static int[] getCalorieArray() {
        int proteinCount = (int) java.util.Arrays.stream(proteinCheckBoxes).filter(JCheckBox::isSelected).count();
        int extraCount = (int) java.util.Arrays.stream(extraCheckBoxes).filter(JCheckBox::isSelected).count();
        int sauceCount = (int) java.util.Arrays.stream(sauceCheckBoxes).filter(JCheckBox::isSelected).count();

        int[] calArr = new int[proteinCount + extraCount + sauceCount];
        int index = 0;

        for (JCheckBox checkBox : proteinCheckBoxes) {
            if (checkBox.isSelected()) {
                calArr[index++] = getCalories(checkBox.getText());
            }
        }

        for (JCheckBox checkBox : extraCheckBoxes) {
            if (checkBox.isSelected()) {
                calArr[index++] = getCalories(checkBox.getText());
            }
        }

        for (JCheckBox checkBox : sauceCheckBoxes) {
            if (checkBox.isSelected()) {
                calArr[index++] = getCalories(checkBox.getText());
            }
        }

        return calArr;
    }

    private static int getCalories(String option) {
        switch (option) {
            case "Crab Sticks":
                return 60;
            case "Salmon":
                return 100;
            case "Tuna":
                return 150;
            case "Chicken Breasts":
                return 90;
            case "Brisket":
                return 120;
            case "Cucumber":
                return 5;
            case "Carrots":
                return 7;
            case "Mangos":
                return 75;
            case "Eggs":
                return 90;
            case "Caviar":
                return 15;
            case "Avocados":
                return 150;
            case "Cream Cheese":
                return 200;
            case "Soy Sauce":
                return 5;
            case "Sweet n' Sour":
                return 7;
            case "Wasabi":
                return 75;
            case "Mayo":
                return 90;
            default:
                return 0;
        }
    }

    //bubble sort algorithm
    private static void bubbleSort(int[] calArr) {
        int n = calArr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (calArr[j] > calArr[j + 1]) {
                    int temp = calArr[j];
                    calArr[j] = calArr[j + 1];
                    calArr[j + 1] = temp;
                }
            }
        }
    }}



