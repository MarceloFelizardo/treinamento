package com.example.marce.treinamentopratico;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.marce.treinamentopratico.GitHubService.URL_Base;

public class CatchList {

    public static void request(final AppCompatActivity activity, final RecyclerView recyclerView){
        RecyclerView recyclerVieww = (RecyclerView)activity.findViewById(R.id.my_recycler_view);

        // Trata Retrofit e GitHub
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_Base)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Call<List<User>> requestCatalog = service.listCatalog();

        requestCatalog.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(activity, "Erro codigo: " + response.code(),
                            Toast.LENGTH_SHORT).show();
                }else{
                    List<User> listUsers = new ArrayList<User>();
                    listUsers = response.body();

                    recyclerView.setAdapter(new MyAdapter(listUsers, activity));
                    recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(activity, "Erro: " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

}
