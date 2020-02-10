package com.tradinos.mzn.models;

public class City {

    private int id;
    private String name;
    private float delivery_fee;
    private float pickup_fee;
    private int deleted;
    private String advance_time;
    private String gift_advanced_time;


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

    public float getDelivery_fee() {
        return delivery_fee;
    }

    public void setDelivery_fee(float delivery_fee) {
        this.delivery_fee = delivery_fee;
    }

    public float getPickup_fee() {
        return pickup_fee;
    }

    public void setPickup_fee(float pickup_fee) {
        this.pickup_fee = pickup_fee;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public String getAdvance_time() {
        return advance_time;
    }

    public void setAdvance_time(String advance_time) {
        this.advance_time = advance_time;
    }

    public String getGift_advanced_time() {
        return gift_advanced_time;
    }

    public void setGift_advanced_time(String gift_advanced_time) {
        this.gift_advanced_time = gift_advanced_time;
    }
}
