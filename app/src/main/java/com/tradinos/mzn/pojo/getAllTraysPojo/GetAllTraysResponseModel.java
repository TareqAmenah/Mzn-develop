package com.tradinos.mzn.pojo.getAllTraysPojo;

import com.tradinos.mzn.models.Tray;

import java.util.ArrayList;

public class GetAllTraysResponseModel {

    private boolean status;
    private ArrayList<Tray> data;
    private String message;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<Tray> getData() {
        return data;
    }

    public void setData(ArrayList<Tray> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
