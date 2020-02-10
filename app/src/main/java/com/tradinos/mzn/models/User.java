package com.tradinos.mzn.models;

public class User {

    private int id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String prefred_color;
    private String prefred_flower;
    private String address;
    private String created_at;
    private String updated_at;
    private String image_url = null;
    private int city_id;
    private String area = null;
    private String street = null;
    private String house = null;
    private String token;
    private String device_name;
    private float latitude;
    private float longitude;
    private String device_token;
    private String birthday;

    public User(int id, String name, String lastname, String email, String phone, String prefred_color, String prefred_flower, String address, String created_at, String updated_at, String image_url, int city_id, String area, String street, String house, String token, String device_name, float latitude, float longitude, String device_token, String birthday) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.prefred_color = prefred_color;
        this.prefred_flower = prefred_flower;
        this.address = address;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.image_url = image_url;
        this.city_id = city_id;
        this.area = area;
        this.street = street;
        this.house = house;
        this.token = token;
        this.device_name = device_name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.device_token = device_token;
        this.birthday = birthday;
    }

    //*************** Getters ********************

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPrefred_color() {
        return prefred_color;
    }

    public String getPrefred_flower() {
        return prefred_flower;
    }

    public String getAddress() {
        return address;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getImage_url() {
        return image_url;
    }

    public int getCity_id() {
        return city_id;
    }

    public String getArea() {
        return area;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getToken() {
        return token;
    }

    public String getDevice_name() {
        return device_name;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getDevice_token() {
        return device_token;
    }

    public String getBirthday() {
        return birthday;
    }


    //*************** Setters ********************

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPrefred_color(String prefred_color) {
        this.prefred_color = prefred_color;
    }

    public void setPrefred_flower(String prefred_flower) {
        this.prefred_flower = prefred_flower;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
