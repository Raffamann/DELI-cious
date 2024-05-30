package com.pluralsight;
import java.util.ArrayList;
public class Order {
    private ArrayList<Sandwich> sandwiches;
    private ArrayList<Chip> chips;
    private ArrayList<Drink> drinks;

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.drinks = new ArrayList<>();

    }

    @Override
    public String toString() {
        return ("----Order Details----\n" +
                "----Sandwiches----\n" +
                "%s\n" +
                "----Drinks----\n" +
                "%s\n----Chips----\n" +
                "%s\n" +
                "Order Total : $%.2f")
                .formatted(sandwiches, drinks, chips, getTotal());
    }

    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public ArrayList<Chip> getChips() {
        return chips;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }
    public double getTotal() {
        double total = 0.0;
        for (Sandwich sandwich:sandwiches){
            total+=sandwich.getPrice();
        }
        for (Drink drink:drinks){
            total+=drink.getPrice();
        }
        for (Chip chip:chips){
            total+= chip.getPrice();
        }
        return total;
    }
}

