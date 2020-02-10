package com.tradinos.mzn.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Arrangement implements Serializable {

    /*

    {
        "id": 5,
        "name": "Exotic weave",
        "price": "195 - 240",
        "description": "Exotic orchids and Mzn signature weave the perfect pair.\r\n\r\nSmall vase size 14 cm diameter \r\nLarge vase size 17 cm diameter",
        "image_url": "http://mzn-develop.tradinos.com/arrangment_image/arrangment5.jpg",
        "trans_img": "http://mzn-develop.tradinos.com/arrangment_image/arrangmenttrans_small5.png",
        "activated": 1,
        "sizes": [ ],
        "colors": [ ],
        "images": [ ]
    }
     */


    private int id;
    private String name;
    private String price;
    private String description;
    private String image_url;
    private String trans_img;
    private int activated;
    private ArrayList<ArrangementSize> sizes;
    private ArrayList<ArrangementColors> colors;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getTrans_img() {
        return trans_img;
    }

    public void setTrans_img(String trans_img) {
        this.trans_img = trans_img;
    }

    public int getActivated() {
        return activated;
    }

    public void setActivated(int activated) {
        this.activated = activated;
    }

    public ArrayList<ArrangementSize> getSizes() {
        return sizes;
    }

    public void setSizes(ArrayList<ArrangementSize> sizes) {
        this.sizes = sizes;
    }

    public ArrayList<ArrangementColors> getColors() {
        return colors;
    }

    public void setColors(ArrayList<ArrangementColors> colors) {
        this.colors = colors;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public class ArrangementSize implements Serializable{

        /*
         {
            "id": 373,
            "size_id": 2,
            "name": "Small",
            "price": 195,
            "trans_img": "http://mzn-develop.tradinos.com/arrangment_image/arrangmenttrans_small5.png"
        }
         */


        private int id;
        private int size_id;
        private String name;
        private int price;
        private String trans_img;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSize_id() {
            return size_id;
        }

        public void setSize_id(int size_id) {
            this.size_id = size_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getTrans_img() {
            return trans_img;
        }

        public void setTrans_img(String trans_img) {
            this.trans_img = trans_img;
        }
    }

    class ArrangementColors implements Serializable{

        /*
        {
            "id": 3,
            "color_id": 3,
            "name": "red"
        }
         */
        private int id;
        private int color_id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getColor_id() {
            return color_id;
        }

        public void setColor_id(int color_id) {
            this.color_id = color_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
