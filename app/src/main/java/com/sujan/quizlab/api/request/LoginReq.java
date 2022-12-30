package com.sujan.quizlab.api.request;

import okhttp3.RequestBody;

public class LoginReq {
    private RequestBody phone;
    private RequestBody password;

    public RequestBody getPhone() {
        return phone;
    }

    public RequestBody getPassword() {
        return password;
    }

    public void setPhone(RequestBody phone) {
        this.phone = phone;
    }

    public void setPassword(RequestBody password) {
        this.password = password;
    }
}
