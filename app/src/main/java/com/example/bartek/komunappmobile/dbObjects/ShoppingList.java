package com.example.bartek.komunappmobile.dbObjects;

import java.util.ArrayList;

public class ShoppingList {

    private int shoppingListId;
    private String description;


    public ShoppingList(int shoppingListId, String description) {
        this.shoppingListId = shoppingListId;
        this.description = description;
    }

    public int getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(int shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
