package com.tradinos.mzn.pojo.SigninPojo;

import com.tradinos.mzn.models.User;

public class SinginResponseModel {

    private boolean status;
    private Data data;
    private String message;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public class Data {
        private String token;
        User user;


        // Getter Methods

        public String getToken() {
            return token;
        }

        public User getUser() {
            return user;
        }

    }
}
