package com.tradinos.mzn.pojo.setOrderPojo;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SetOrderModel {

    private int user_id;
//    private ArrayList<ArrangementInOrder> arrangments;
    private String arrangments;
//    private ArrayList<TrayInOrder> trays;
    private String trays;
    private int payment_method;
    private int time_id;
    private String area;
    private int city;
    private String street;
    private String house_number;

    @SerializedName("long")
    private double lng;
    private double lat;
    private int send_to_friend;
    private int add_card;
    private int card_id;
    private String card_message;
    private String delivery_date;
    private String note;
    private File order_img;


    public SetOrderModel(int user_id, ArrayList<ArrangementInOrder> arrangments, ArrayList<TrayInOrder> trays,
                         int payment_method, int time_id, String area, int city, String street,
                         String house_number, double lng, double lat, int send_to_friend, int add_card,
                         int card_id, String card_message, String delivery_date, String note) {
        this.user_id = user_id;
        this.arrangments = getArrangementsListAsJsonArray(arrangments).toString();
        this.trays = getTraysListAsJsonArray(trays).toString();
        this.payment_method = payment_method;
        this.time_id = time_id;
        this.area = area;
        this.city = city;
        this.street = street;
        this.house_number = house_number;
        this.lng = lng;
        this.lat = lat;
        this.send_to_friend = send_to_friend;
        this.add_card = add_card;
        this.card_id = card_id;
        this.card_message = card_message;
        this.delivery_date = delivery_date;
        this.note = note;


        //TODO check upload file
        order_img = new File("/drawable/ic_image_black_24dp.xml");
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

        // MultipartBody.Part is used to send also the actual file name
//        order_img = MultipartBody.Part.createFormData("order_img", file.getName(), requestFile);

    }

    public JSONObject getOrderModelAsJsonObject(){

        JSONObject orderModel = new JSONObject();

        try {
            orderModel.put("user_id",user_id);
            orderModel.put("arrangments",arrangments);
            orderModel.put("trays",trays);
            orderModel.put("payment_method",payment_method);
            orderModel.put("time_id",time_id);
            orderModel.put("area",area);
            orderModel.put("city",city);
            orderModel.put("street",street);
            orderModel.put("house_number",house_number);
            orderModel.put("lng",lng);
            orderModel.put("lat",lat);
            orderModel.put("send_to_friend",send_to_friend);
            orderModel.put("add_card",add_card);
            orderModel.put("delivery_date",delivery_date);
            orderModel.put("note",note);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return orderModel;
    }

    public Map<String, String> getOrderAsMap(){
        Map<String, String> map = new HashMap<>();
        map.put("user_id", String.valueOf(user_id));
        map.put("arrangments",arrangments);
        map.put("trays",trays);
        map.put("payment_method", String.valueOf(payment_method));
        map.put("time_id", String.valueOf(time_id));
        map.put("area",area);
        map.put("city", String.valueOf(city));
        map.put("street", String.valueOf(street));
        map.put("house_number", String.valueOf(house_number));
        map.put("lng", String.valueOf(lng));
        map.put("lat", String.valueOf(lat));
        map.put("send_to_friend", String.valueOf(send_to_friend));
        map.put("add_card", String.valueOf(add_card));
        map.put("delivery_date",delivery_date);
        map.put("note",note);

        return map;
    }

    private JSONArray getArrangementsListAsJsonArray(ArrayList<ArrangementInOrder> arrangments){

        JSONArray arrangementJsonArray = new JSONArray();
        for (ArrangementInOrder arrangment : arrangments) {
            arrangementJsonArray.put(arrangment.getArrangementAsJsonObject());
        }
        return arrangementJsonArray;
    }

    private JSONArray getTraysListAsJsonArray( ArrayList<TrayInOrder> trays){

        JSONArray trayJsonArray = new JSONArray();

        for (TrayInOrder tray : trays) {
            trayJsonArray.put(tray.getTrayAsJsonObject());
        }

        return trayJsonArray;
    }

    public String getArrangments() {
        return arrangments;
    }

    public void setArrangments(String arrangments) {
        this.arrangments = arrangments;
    }

    public String getTrays() {
        return trays;
    }

    public void setTrays(String trays) {
        this.trays = trays;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(int payment_method) {
        this.payment_method = payment_method;
    }

    public int getTime_id() {
        return time_id;
    }

    public void setTime_id(int time_id) {
        this.time_id = time_id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
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

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getSend_to_friend() {
        return send_to_friend;
    }

    public void setSend_to_friend(int send_to_friend) {
        this.send_to_friend = send_to_friend;
    }

    public int getAdd_card() {
        return add_card;
    }

    public void setAdd_card(int add_card) {
        this.add_card = add_card;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static class ArrangementInOrder{
        private int id;
        private int quantity;
        private String note;
        private int color_id;

        public ArrangementInOrder(int id, int quantity, String note) {
            this.id = id;
            this.quantity = quantity;
            this.note = note;
        }

        public ArrangementInOrder(int id, int quantity, String note, int color_id) {
            this.id = id;
            this.quantity = quantity;
            this.note = note;
            this.color_id = color_id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public int getColor_id() {
            return color_id;
        }

        public void setColor_id(int color_id) {
            this.color_id = color_id;
        }

        public String getAsString() {

            return "{\"id\": \"" + id + "\", " + "\"quantity\": \"" + quantity + "\", " + "\"note\": \"" + note + "\"}";
        }

        public JSONObject getArrangementAsJsonObject(){

            JSONObject arrangement = new JSONObject();

            try {
                arrangement.put("id", id);
                arrangement.put("quantity", quantity);
                arrangement.put("note", note);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return arrangement;
        }
    }

    public static class TrayInOrder{
        private int id;
        private int quantity;
        private String note;

        public TrayInOrder(int id, int quantity, String note) {
            this.id = id;
            this.quantity = quantity;
            this.note = note;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }


        public JSONObject getTrayAsJsonObject(){

            JSONObject tray = new JSONObject();

            try {
                tray.put("id", id);
                tray.put("quantity", quantity);
                tray.put("note", note);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return tray;
        }
    }

}
