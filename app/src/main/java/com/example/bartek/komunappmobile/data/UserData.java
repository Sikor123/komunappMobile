package com.example.bartek.komunappmobile.data;

import com.example.bartek.komunappmobile.dbObjects.ShoppingList;

import java.util.ArrayList;

public class UserData  {
    private static ArrayList<ShoppingList> shoppingLists = new ArrayList<ShoppingList>();

    public static ArrayList<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }

    public static void setShoppingLists(ArrayList<ShoppingList> shoppingLists) {
        UserData.shoppingLists = shoppingLists;
    }
}
