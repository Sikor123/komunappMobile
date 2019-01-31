package com.example.bartek.komunappmobile.jsony;

public class ShoppingItemBody {
    private Integer listId;
    private String description;
    private double price;


    public ShoppingItemBody(Integer listId, String description, double price) {
        this.listId = listId;
        this.description = description;
        this.price = price;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
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
