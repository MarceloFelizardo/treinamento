package com.example.marce.treinamentopratico;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.marce.treinamentopratico.GitHubService.URL_Base;

public class FragListUsers extends Fragment{

    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_list_users, container, false);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.my_recycler_view);

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
                    Toast.makeText(getActivity(), "Erro codigo: " + response.code(),
                            Toast.LENGTH_SHORT).show();
                }else{
                    List<User> listUsers = new ArrayList<User>();
                    listUsers = response.body();

                    recyclerView.setAdapter(new MyAdapter(listUsers, (AppCompatActivity) getActivity()));
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                    //recyclerView
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getActivity(), "Erro: " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}
