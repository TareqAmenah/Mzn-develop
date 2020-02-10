package com.tradinos.mzn.pojo.SigninPojo;

public class SinginModel {
    private String email;
    private String password;
    private String device_token;
    private String device_name;
    private String version;

    public SinginModel(String email, String password, String device_token, String device_name, String version) {
        this.email = email;
        this.password = password;
        this.device_token = device_token;
        this.device_name = device_name;
        this.version = version;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDevice_token() {
        return device_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
