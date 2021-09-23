package com.example.retrofitmvvm;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts/")
    Call<ApiResponse> getAllPosts();


}
