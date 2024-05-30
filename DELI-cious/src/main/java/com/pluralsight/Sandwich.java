package com.pluralsight;
import java.util.ArrayList;
public class Sandwich {
    private String size;
    private String bread;
    private ArrayList<String> sauces;
    private ArrayList<String> toppings;
    private boolean isToasted;
    private String meat;
    private String cheese;
    private boolean extraMeat;
    private boolean extraCheese;

     // constructor
    public Sandwich(String size, String bread, ArrayList<String> sauces, ArrayList<String> toppings, boolean isToasted, String meat, String cheese, boolean extraMeat, boolean extraCheese) {
        this.size = size;
        this.bread = bread;
        this.sauces = sauces;
        this.toppings = toppings;
        this.isToasted = isToasted;
        this.meat = meat;
        this.cheese = cheese;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
        this.sauces = new ArrayList<>();
        this.toppings = new ArrayList<>();
    }

    @Override
    public String toString() {
        return ("""
                size          %s
                meat          %s
                extraMeat     %s
                cheese        %s
                extraCheese   %s
                bread         %s
                sauces        %s
                toppings      %s
                toasted       %s
                price         $%.2f
                """)
                .formatted(size, meat, extraMeat, cheese, extraCheese, bread, sauces, toppings, isToasted, getPrice());
    }
    // my getters and setters
    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }
    public boolean isExtraMeat() {
        return extraMeat;
    }
    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }
    public boolean isExtraCheese() {
        return extraCheese;
    }
    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }
    public ArrayList<String> getSauces() {
        return sauces;
    }
    public void setSauces(ArrayList<String> sauces) {
        this.sauces = sauces;
    }
    public ArrayList<String> getToppings() {
        return toppings;
    }
    public void setToppings(ArrayList<String> toppings){
        this.toppings = toppings;
    }
    public boolean isToasted() {
        return isToasted;
    }
    public void setToasted(boolean toasted){
        isToasted = toasted;
    }
    public double getPrice() {
        double price = 0.0;
        if (getSize().equalsIgnoreCase("4\"")){ //If the sandwich is 4"
            price = 5.5;
            if (!getMeat().isEmpty()) {
                price+=1.0;
            }
            if (extraMeat){
                price+=0.5;
            }
            if (!getCheese().isEmpty()) {
                price+=0.75;
            }
            if (extraCheese){
                price+=0.3;
            }
            return price;
        } else if (getSize().equalsIgnoreCase("8\"")) {
            price=7.0;
            if (!getMeat().isEmpty()) {
                price+=2.0;
            }
            if (extraMeat) {
                price+=1.0;
            }
            if (!getCheese().isEmpty()) {
                price+=1.5;
            }
            if (extraCheese) {
                price+=0.6;
            }
            return price;
        } else if (getSize().equalsIgnoreCase("12\"")) {
            price=8.5;
            if (getMeat().equalsIgnoreCase("y")) {
                price+=3.0;
            }
            if (extraMeat) {
                price+=1.5;
            }
            if (getCheese().equalsIgnoreCase("y")) {
                price+=2.25;
            }
            if (extraCheese) {
                price+=0.9;
            }
        }
        return price;

    }
}



