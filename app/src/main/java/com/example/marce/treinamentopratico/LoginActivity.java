package com.example.marce.treinamentopratico;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class LoginActivity extends AppCompatActivity {
    //FragmentManager fm = this.getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ChangeFragments.trocaFrag(this, new FragLogin(), R.id.local_login);

    }


}
