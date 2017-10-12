package com.example.marce.treinamentopratico;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import retrofit2.Retrofit;

import static com.example.marce.treinamentopratico.GitHubService.URL_Base;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChangeFragments.trocaFrag(this, new FragListUsers(), R.id.local_main);


    }

    @Override
    public void onBackPressed() {
        //String str = Integer.toString(getSupportFragmentManager().getBackStackEntryCount());
        //Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

        // Verifica retorno das fragments, não permitir >1
        if (getSupportFragmentManager().getBackStackEntryCount() > 1 ) {
            super.onBackPressed();
        }

    }


}
