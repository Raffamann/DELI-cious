package com.pluralsight;

public class Drink {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return ("size\t%s\nflavor\t%s\nprice\t$%.2f").formatted(size, flavor, getPrice());
    }

    public double getPrice() {
        if (size.equalsIgnoreCase("small")){
            return 2;
        } else if (size.equalsIgnoreCase("medium")){
            return 2.5;
        } else {
            return 3;
        }
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}
