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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.marce.treinamentopratico.GitHubReposit.URL_Reposit;

public class FragListReposit extends Fragment {
    private RecyclerView recyclerView;
    private List<Repos> listReposit;
    private String nomeReposAtual;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.frag_list_reposit, container, false);

        progressBar = (ProgressBar)rootView.findViewById(R.id.progress_bar_list_repos);
        progressBar.setVisibility(rootView.VISIBLE);

        nomeReposAtual = getArguments().getString("nome2");

        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view_reposit);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_Reposit)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubReposit gitHubReposit = retrofit.create(GitHubReposit.class);
        Call<List<Repos>> requestCatalog = gitHubReposit.listReposit(nomeReposAtual);

        requestCatalog.enqueue(new Callback<List<Repos>>() {
            @Override
            public void onResponse(Call<List<Repos>> call, Response<List<Repos>> response) {
                if(!response.isSuccessful()){
                    progressBar.setVisibility(rootView.GONE);

                    Toast.makeText(getActivity(), "Erro codigo: " + response.code(),
                            Toast.LENGTH_SHORT).show();
                }else{
                    progressBar.setVisibility(rootView.GONE);

                    listReposit = new ArrayList<Repos>();
                    listReposit = response.body();

                    recyclerView.setAdapter(new AdapterReposit(listReposit, (AppCompatActivity) getActivity()));
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
                }
            }

            @Override
            public void onFailure(Call<List<Repos>> call, Throwable t) {
                progressBar.setVisibility(rootView.GONE);
                
                Toast.makeText(getActivity(), "Erro: " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}
