package com.tradinos.mzn.models;

import java.util.ArrayList;

public class Tray {

    private int id;
    private String name;
    private String description;
    private String image_url;
    private int activated;
    private int price;
    private int mzn_tray_id;
    private String updated_at;
    private String created_at;
    private int mzn_arrangment_id;
    private ArrayList<String> images;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getActivated() {
        return activated;
    }

    public void setActivated(int activated) {
        this.activated = activated;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMzn_tray_id() {
        return mzn_tray_id;
    }

    public void setMzn_tray_id(int mzn_tray_id) {
        this.mzn_tray_id = mzn_tray_id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getMzn_arrangment_id() {
        return mzn_arrangment_id;
    }

    public void setMzn_arrangment_id(int mzn_arrangment_id) {
        this.mzn_arrangment_id = mzn_arrangment_id;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

}
