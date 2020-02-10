package com.tradinos.mzn.pojo.getArrangementsOrders;

import com.tradinos.mzn.models.ArrangementOrder;

import java.util.ArrayList;

public class GetArrangementsOrdersResponse {

    private boolean status;
    private ArrayList<ArrangementOrder> data;
    private String message;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<ArrangementOrder> getData() {
        return data;
    }

    public void setData(ArrayList<ArrangementOrder> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


