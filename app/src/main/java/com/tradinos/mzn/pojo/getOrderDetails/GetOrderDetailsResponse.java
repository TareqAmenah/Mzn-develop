package com.tradinos.mzn.pojo.getOrderDetails;

import com.tradinos.mzn.models.OrderDetails;

public class GetOrderDetailsResponse {

    private boolean status;
    private OrderDetails data;
    private String message;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public OrderDetails getData() {
        return data;
    }

    public void setData(OrderDetails data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
