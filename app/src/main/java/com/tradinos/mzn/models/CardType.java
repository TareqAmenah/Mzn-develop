package com.tradinos.mzn.models;

public class CardType {

    private int id;
    private String name;
    private float fee;

    public CardType(int id, String name, float fee) {
        this.id = id;
        this.name = name;
        this.fee = fee;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }
}
