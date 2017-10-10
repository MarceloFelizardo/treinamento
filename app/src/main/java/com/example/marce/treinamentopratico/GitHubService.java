package com.example.marce.treinamentopratico;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GitHubService {
    //public static final String URL_Base = "https://api.github.com/users/";
    //@GET("LucasFranc")

    public static final String URL_Base = "https://api.github.com/";

    @GET("users")
    Call<List<User>> listCatalog();
}
