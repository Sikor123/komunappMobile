package com.example.bartek.komunappmobile.data;

import com.example.bartek.komunappmobile.dbObjects.ShoppingList;

import java.util.ArrayList;

public class UserData  {
    private static ArrayList<ShoppingList> shoppingLists = new ArrayList<ShoppingList>();
    private static String token;
    private static Integer flatId;


    public static Integer getFlatId() {
        return flatId;
    }

    public static void setFlatId(Integer flatId) {
        UserData.flatId = flatId;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        UserData.token = token;
    }

    public static ArrayList<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }

    public static void setShoppingLists(ArrayList<ShoppingList> shoppingLists) {
        UserData.shoppingLists = shoppingLists;
    }
}
