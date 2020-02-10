package com.tradinos.mzn.pojo.getFormData;

import com.tradinos.mzn.models.FormData;

public class GetFormDataResponse {

    private boolean status;
    private FormData data;
    private String message;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public FormData getData() {
        return data;
    }

    public void setData(FormData data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
