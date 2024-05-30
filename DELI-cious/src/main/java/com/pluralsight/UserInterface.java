package com.pluralsight;
import java.util.*;
public class UserInterface {
    static Scanner scanner = new scanner(System.in);

    static Order order = new Order();

    public UserInterface() {
    }

    public void homeScreen() {
        System.out.println("""
                Hello! Welcome to the DELI-cious Deli!!
                ---------------------------------------
                1) New order
                0) Exit""");

        try {
            int choice = scanner.nextInt();

            if (choice == 1) {
                orderScreen();
            } else if (choice == 0) {
                System.exit(0);
            } else {
                System.out.println("Oops please select a correct input 1 or 2");
                homeScreen();
            }

        } catch (InputMismatchException e) {
            System.out.println("\n ERROR: the input must be a number, please select a number :) \n");
            scanner.nextLine();
            homeScreen();
        }

    }

    private void orderScreen() {
        System.out.println("""
                ----------------------
                1) Add Sandwich
                2) Add Drink
                3) Add Chips
                4) Checkout
                0) Cancel Order
                """);
        try {
            int choice = scanner.nextInt();
            if (choice == 1) {
                sandwichScreen();
            } else if (choice == 2) {
                drinkScreen();
            } else if (choice == 3) {
                chipScreen();
            } else if (choice == 4) {
                checkoutScreen();
            } else if (choice == 0) {
                cancelOrder();
            } else {
                System.out.println("Oops! Thats not in range, please select a number between or 0 - 4");
                orderScreen();
            }
        } catch (InputMismatchException e) {
            System.out.println("\n ERROR: the input must be a number between or  0 - 4\n");
            scanner.nextLine();
            orderScreen();
        }
    }

    private void sandwichScreen() {
        scanner.nextLine();
        // option for different sizes

        System.out.println("");
        System.out.println("Please select a size");
        String size = sizeSelection();

        // options for a specific bread type

        System.out.println("");
        System.out.println("------------");
        System.out.println("Please select a bread type");
        String bread = breadSelection();

        //options for meats

        System.out.println("");
        System.out.println("-------------");
        System.out.println("Please select a meat");
        String meat = meatSelection();
        //does the customer want extra meat?
        boolean extraMeat = false;
        if (!meat.equalsIgnoreCase("none")) {
            extraMeat = extraToppings(meat);
        }

        //options for cheeses

        System.out.println("");
        System.out.println("-------------");
        System.out.println("Please select a cheese");
        String cheese = cheeseSelection();
        boolean extraCheese = false;
        if (!meat.equalsIgnoreCase("none")) {
            extraCheese = extraToppings(cheese);
        }

        System.out.println("");
        System.out.println("Please select your toppings");
        ArrayList<String> toppings = new ArrayList<>();
        toppingsSelection(toppings);

        System.out.println("");
        System.out.println("Please select your sauce(s)");
        ArrayList<String> sauces = new ArrayList<>();
        saucesSelection(sauces);

        System.out.println("-------------");
        System.out.println("Would you like your sandwich to be toasted? \n 1) Yes \n 2) No");

        int toasted = scanner.nextInt();
        boolean isToasted = false;
        if (toasted == 1) {
            isToasted = true;
        }
        Sandwich sandwich = new Sandwich(size, meat, cheese extraCheese, bread, isToasted);
        sandwich.setSauces(sauces);
        sandwich.setToppings(toppings);
        order.getSandwiches().add(sandwich);
        // The user goes back to the order screen
        orderScreen();
    }

    private String sizeSelection() {
        System.out.println("""
                1) 4"
                2) 8"
                3) 12"
                """);
        int opt = scanner.nextInt();
        String size = "";
        switch (opt) {
            case 1:
                size = "4 ";
                break;
            case 2:
                size = "8";
                break;
            case 3:
                size = "12";
                break;
            default:
                System.out.println("Oops that's not a valid option");
                sizeSelection();
                break;
        }
        return size;
    }

    private String breadSelection() {
        System.out.println("");
        System.out.println("""
                1) White 
                2) Wheat
                3) Rye
                4) Wrap
                """);
        int opt = scanner.nextInt();
        String bread = "";
        switch (opt) {
            case 1:
                bread = "White";
                break;
            case 2:
                bread = "Wheat";
                break;
            case 3:
                bread = "Rye";
                break;
            case 4:
                bread = "Wrap";
                break;
            default:
                System.out.println("Oops not a valid input");
        }
        return bread;
    }

    private String meatSelection() {
        System.out.println("");
        System.out.println("""
                1) Steak 
                2) Ham
                3) Salami
                4) Roast Beef
                5) Chicken
                6) Bacon
                0) None
                """);
        int opt = scanner.nextInt();
        String meat = "";
        switch (opt) {
            case 1:
                meat = "Steak";
                break;
            case 2:
                meat = "Ham";
                break;
            case 3:
                meat = "Salami";
                break;
            case 4:
                meat = "Roast Beef";
                break;
            case 5:
                meat = "Chicken";
                break;
            case 6:
                meat = "Bacon";
            case 0:
                meat = "None";
                break;
            default:
                System.out.println("Oops not a valid input");
        }
        return meat;
    }

    private String cheeseSelection() {
        System.out.println("");
        System.out.println("""
                1) American 
                2) Provolone
                3) Chedder
                4) Swiss
                0) None
                """);
        int opt = scanner.nextInt();
        String cheese = "";
        switch (opt) {
            case 1:
                cheese = "American";
                break;
            case 2:
                cheese = "Provolone";
                break;
            case 3:
                cheese = "Chedder";
                break;
            case 4:
                cheese = "Swiss";
                break;
            case 0:
                cheese = "None";
                break;
            default:
                System.out.println("Oops not a valid input");
        }
        return cheese;
    }

    private void saucesSelection(ArrayList<String> sauces) {
        System.out.println("""
                1) Mayo
                2) Mustard
                3) ketchup
                4) Ranch
                5) Thousand Island
                6) Vinaigrette
                0) None
                """);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                sauces.add("Mayo");
                break;
            case 2:
                sauces.add("Mustard");
                break;
            case 3:
                sauces.add("Ketchup");
                break;
            case 4:
                sauces.add("Ranch");
                break;
            case 5:
                sauces.add("Thousand Island");
                break;
            case 6:
                sauces.add("Vinaigrette");
                break;
            case 0:
                sauces.add("None");
                break;
            default:
                System.out.println("Sorry not an available option");
                saucesSelection(sauces);
                break;
        }
        if (choice != 0) {
            System.out.println("""
                    1) Add another
                    2) Done
                    """);
            choice = scanner.nextInt();
            if (choice == 1) {
                saucesSelection(sauces);
            }
        }
    }

    private void toppingsSelection(ArrayList<String> toppings) {
        System.out.println("""
                1) Lettuce
                2) Peppers
                3) Onions
                4) Tomatoes
                5) Jalapenos
                6) Cucumbers
                7) Pickles
                8) Guacamole
                9) Mushrooms
                0) None
                """);

        int opt = scanner.nextInt();

        switch (opt) {
            case 1:
                toppings.add("Lettuce");
                break;
            case 2:
                toppings.add("Peppers");
                break;
            case 3:
                toppings.add("Onions");
                break;
            case 4:
                toppings.add("Tomatoes");
                break;
            case 5:
                toppings.add("Jalapenos");
                break;
            case 6:
                toppings.add("Cucumbers");
                break;
            case 7:
                toppings.add("Pickles");
                break;
            case 8:
                toppings.add("Guacamole");
                break;
            case 9:
                toppings.add("Mushrooms");
                break;
            case 0:
                toppings.add("None");
                break;
            default:
                System.out.println("sorry! That's not an available option");
                toppingsSelection(toppings);
                break;
        }


        if (opt != 0) {
            System.out.println("""
                    1) Add another topping
                    2) Done
                    """);
            opt = scanner.nextInt();
            if (opt == 1) {
                toppingsSelection(toppings);
            } else if (opt == 2) {
                System.out.println("Toppings saved");
            } else {
                System.out.println("Input out of range");
            }
        }
    }

    private boolean extraToppings(String topping) {
        if (!topping.isEmpty()) {
            System.out.println("Add extra!! \n 1) Yes \n 2) No");

            int choice = scanner.nextInt();
            if (choice == 1) {
                return true;
            }
        }
        return false;
    }

    private void drinkScreen() {
        System.out.println("");
        System.out.println("------------");
        System.out.println("Please select a drink size");
        String size = drinkSize();

        System.out.println("");
        System.out.println("------------");
        System.out.println("Please select a drink flavor");
        String flavor = drinkFlavor();

        Drink drink = new Drink(size, flavor);
        order.getDrinks().add(drink);
        orderScreen();
    }

    private String drinkSize() {
        System.out.println("""
                1) Small
                2) Medium
                3) Large
                """);
        int opt = scanner.nextInt();
        String size = "";

        switch (opt) {
            case 1:
                size = "Small";
                break;
            case 2:
                size = "Medium";
                break;
            case 3:
                size = "Large";
                break;
            default:
                System.out.println("Sorry that's not an available option");
                drinkSize();
                break;
        }
        return size;
    }
    private String drinkFlavor() {
        System.out.println("""
                1) Sprite
                2) coke
                3) Lemonade
                4) Berry slush
                5) Strawberry slush
                6) Iced tea (unsweetened)
                7) Iced tea (sweetened)
                """);
        int opt = scanner.nextInt();
        String flavor = "";

        switch (opt) {
            case 1:
                flavor = "Sprite";
                break;
            case 2:
                flavor = "Coke";
                break;
            case 3:
                flavor = "Lemonade";
                break;
            case 4:
                flavor = "Berry slush";
                break;
            case 5:
                flavor = "Strawberry slush";
                break;
            case 6:
                flavor = "Iced tea (unsweetened)";
                break;
            case 7:
            default:
                System.out.println("Sorry that's not an available option");
                drinkFlavor();
                break;
        }
        return flavor;
    }
    private void chipScreen() {
        String type = "";
        System.out.println("---------------------------");
        System.out.println("Select a chip type");
        System.out.println("""
                1) Original
                2) Nacho Cheese
                3) Cool Ranch
                4) Sour Cream & Onion
                5) Salt & Vinegar
                """);

        int choice = scanner.nextInt();
        if (choice == 1) {
            type = "Original";
        } else if (choice==2) {
            type="Nacho Cheese";
        } else if (choice==3) {
            type="Cool Ranch";
        } else if (choice==4) {
            type="Sour Cream & Onion";
        } else if (choice==5) {
            type="Salt & Vinegar";
        } else {
            System.out.println("Sorry that's not an available option");
            chipScreen();
        }

        Chip chip = new Chip(type);
        order.getChips().add(chip);
        orderScreen();
    }

    private void checkoutScreen() {
        System.out.println("---------------------------");
        System.out.println("----Order details----");

        // Print order
        if (!order.getSandwiches().isEmpty()){
            System.out.println("----Sandwiches----");
            displayOrder(order.getSandwiches());
        }

        if (!order.getDrinks().isEmpty()){
            System.out.println("----Drinks----");
            displayOrder(order.getDrinks());
        }

        if (!order.getChips().isEmpty()){
            System.out.println("----Chips----");
            displayOrder(order.getChips());
        }

        // Print out the total of the order
        System.out.println("---------------------------");
        System.out.printf("Order total : $%.2f\n\n", order.getTotal());

        System.out.println("""
                1) Confirm
                2) Cancel
                """);
        int choice = scanner.nextInt();
        if (choice==1){
            // Save receipt to file
            ReceiptFileManager receiptFileManager = new ReceiptFileManager(order);
            receiptFileManager.saveReceipt();
            cancelOrder();
        } else if (choice==2){
            cancelOrder();
        }
    }

    private <T> void displayOrder(ArrayList<T> items){
        for (T item : items){
            System.out.println(item);
        }
    }

    private void cancelOrder() {
        order.getSandwiches().clear();
        order.getChips().clear();
        order.getDrinks().clear();
        homeScreen();
    }
}