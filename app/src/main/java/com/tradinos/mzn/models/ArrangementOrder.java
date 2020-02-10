package com.tradinos.mzn.models;

import com.google.gson.annotations.SerializedName;

public class ArrangementOrder {

    private int id;
    private int status;
    private String address;
    private String created_date;
    private String delivery_date;
    private int delivery_time;
    private double total;
    private int user_id;
    private String note;
    private String area;
    private String street;
    private String house_number;
    @SerializedName("long")
    private String lng;
    private String lat;
    private int city_id;
    private String order_img;
    private String payment_method;
    private int payment_status;
    private int delivery_fee;
    private int send_to_friend;
    private String friend_message;
    private int add_card;
    private String card_id;
    private int card_fee;
    private String friend_name;
    private String friend_phone;
    private double tax;
    private int subtotal;
    private int tax_per;
    private String voucher_id;
    private String voucher_per;
    private String voucher_value;
    private City city;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public int getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(int delivery_time) {
        this.delivery_time = delivery_time;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse_number() {
        return house_number;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getOrder_img() {
        return order_img;
    }

    public void setOrder_img(String order_img) {
        this.order_img = order_img;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public int getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(int payment_status) {
        this.payment_status = payment_status;
    }

    public int getDelivery_fee() {
        return delivery_fee;
    }

    public void setDelivery_fee(int delivery_fee) {
        this.delivery_fee = delivery_fee;
    }

    public int getSend_to_friend() {
        return send_to_friend;
    }

    public void setSend_to_friend(int send_to_friend) {
        this.send_to_friend = send_to_friend;
    }

    public String getFriend_message() {
        return friend_message;
    }

    public void setFriend_message(String friend_message) {
        this.friend_message = friend_message;
    }

    public int getAdd_card() {
        return add_card;
    }

    public void setAdd_card(int add_card) {
        this.add_card = add_card;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public int getCard_fee() {
        return card_fee;
    }

    public void setCard_fee(int card_fee) {
        this.card_fee = card_fee;
    }

    public String getFriend_name() {
        return friend_name;
    }

    public void setFriend_name(String friend_name) {
        this.friend_name = friend_name;
    }

    public String getFriend_phone() {
        return friend_phone;
    }

    public void setFriend_phone(String friend_phone) {
        this.friend_phone = friend_phone;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getTax_per() {
        return tax_per;
    }

    public void setTax_per(int tax_per) {
        this.tax_per = tax_per;
    }

    public String getVoucher_id() {
        return voucher_id;
    }

    public void setVoucher_id(String voucher_id) {
        this.voucher_id = voucher_id;
    }

    public String getVoucher_per() {
        return voucher_per;
    }

    public void setVoucher_per(String voucher_per) {
        this.voucher_per = voucher_per;
    }

    public String getVoucher_value() {
        return voucher_value;
    }

    public void setVoucher_value(String voucher_value) {
        this.voucher_value = voucher_value;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
