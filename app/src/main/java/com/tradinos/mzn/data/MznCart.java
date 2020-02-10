package com.tradinos.mzn.data;

import android.util.Log;

import com.tradinos.mzn.models.ItemInCart;

import java.util.ArrayList;

public class MznCart {

    private ArrayList<ItemInCart> arrangementsList;
    private ArrayList<ItemInCart> traysList;
    private static MznCart INSTANCE;

    public MznCart() {
        arrangementsList = new ArrayList<>();
        traysList = new ArrayList<>();
    }

    public static MznCart getINSTANCE() {

        if(INSTANCE == null)
            INSTANCE = new MznCart();

        return INSTANCE;
    }

    public void addArrangement(ItemInCart arrangement){
        arrangementsList.add(arrangement);
    }

    public void addTray(ItemInCart tray){
        traysList.add(tray);
    }

    public ArrayList<ItemInCart> getArrangementsList() {
        return arrangementsList;
    }

    public ArrayList<ItemInCart> getTraysList() {
        return traysList;
    }

    public float getTotal(){

        float total = 0f;
        for (ItemInCart itemInCart : arrangementsList) {
            total += (itemInCart.getPrice() * itemInCart.getQuantity());
        }

        for (ItemInCart itemInCart : traysList) {
            total += (itemInCart.getPrice() * itemInCart.getQuantity());
        }

        return total;
    }

    public void logCart(){

        Log.d("MznCart arrangements: ", "****************");
        for (int i = 0; i < arrangementsList.size(); i++) {
            Log.d("item " + i , arrangementsList.get(i).toString());
        }



        Log.d("MznCart Tray: ", "****************");
        for (int i = 0; i < traysList.size(); i++) {
            Log.d("item " + i , traysList.get(i).toString());
        }

    }

    public void clear(){
        arrangementsList.clear();
        traysList.clear();
    }

    public boolean isEmpty(){
        return traysList.isEmpty() && arrangementsList.isEmpty();
    }
}
