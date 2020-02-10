package com.tradinos.mzn.pojo.getArrangementsPojo;

import com.tradinos.mzn.models.Arrangement;

import java.util.ArrayList;

public class GetArrangementsResponse {

    private boolean status;
    private ArrayList<Arrangement> data;
    private String message;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<Arrangement> getData() {
        return data;
    }

    public void setData(ArrayList<Arrangement> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
