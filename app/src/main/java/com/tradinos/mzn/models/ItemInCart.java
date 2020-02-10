package com.tradinos.mzn.models;

import androidx.annotation.NonNull;

public class ItemInCart {

    private int id;
    private String name;
    private float price;
    private int quantity;
    private String note;
    private String image_url;

    public ItemInCart(int id, String name, float price, int quantity, String note, String image_url) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.note = note;
        this.image_url = image_url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getNote() {
        return note;
    }

    public String getImage_url() {
        return image_url;
    }


    @NonNull
    @Override
    public String toString() {

        return "id: " + id + ", name: " + name + ", Quantity: " + quantity + ", Price: " + price;


    }


}
