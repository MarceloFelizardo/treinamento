package com.example.marce.treinamentopratico;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubReposit {
    public static final String URL_Reposit = "https://api.github.com/";

    @GET("users/{name}/repos")
    Call<List<Repos>> listReposit(@Path("name") String name);
}
