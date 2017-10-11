package com.example.marce.treinamentopratico;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubServiceUser {

    public static final String URL_BaseUser = "https://api.github.com/";

    @GET("users/{name}")
    Call<User> dataUser(@Path("name") String name);
}
