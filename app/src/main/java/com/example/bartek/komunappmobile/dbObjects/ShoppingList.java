package com.example.bartek.komunappmobile.dbObjects;

import java.util.ArrayList;

public class ShoppingList {

    private int shoppingListId;
    private int userId;
    private int flatId;
    private String description;
    private String date;
    private ArrayList<ShoppingItem> shopping ;

    public ArrayList<ShoppingItem> getShopping() {
        return shopping;
    }

    public void setShopping(ArrayList<ShoppingItem> shopping) {
        this.shopping = shopping;
    }

    public int getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(int shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlatId() {
        return flatId;
    }

    public void setFlatId(int flatId) {
        this.flatId = flatId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}