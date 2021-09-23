package com.example.retrofitmvvm;

import java.util.List;

public class ApiResponse {

    public List<Model> call;

    public ApiResponse(List<Model> getPosts) {
        this.call = getPosts;
    }

    public List<Model> getCall() {
        return call;
    }

    public void setCall(List<Model> call) {
        this.call = call;
    }

    //Any issue brother??
}
