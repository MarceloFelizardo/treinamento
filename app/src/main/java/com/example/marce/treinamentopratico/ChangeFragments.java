package com.example.marce.treinamentopratico;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class ChangeFragments {
    AppCompatActivity activity;
    Fragment fragment;


    public static void trocaFrag(AppCompatActivity activity, Fragment fragment, int id){
        FragmentManager fm = activity.getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(id, fragment).addToBackStack(null);
        ft.commit();
    }

}
