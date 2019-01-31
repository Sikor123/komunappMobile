package com.example.bartek.komunappmobile.dbObjects;

public class ShoppingItem {
    private Integer itemId;
    private String description;
    private double price;

    public ShoppingItem(Integer itemId, String description, double price) {
        this.itemId = itemId;
        this.description = description;
        this.price = price;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
