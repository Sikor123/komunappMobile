package com.example.bartek.komunappmobile.dbObjects;

public class ShoppingItem {
    private String description;
    private int price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ShoppingItem(String description, int price) {
        this.description = description;
        this.price = price;
    }
}
