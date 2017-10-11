package com.example.marce.treinamentopratico;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragReposSelected extends Fragment{
    public TextView txt1, txt2, txt3, txt4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_repos_selected, container, false);

        txt1 = (TextView)rootView.findViewById(R.id.txt_repos_1);
        txt2 = (TextView)rootView.findViewById(R.id.txt_repos_2);
        txt3 = (TextView)rootView.findViewById(R.id.txt_repos_3);

        String name = getArguments().getString("name");
        String id = getArguments().getString("id");
        String url = getArguments().getString("url");

        txt1.setText(name);
        txt2.setText(id);
        txt3.setText(url);

        return rootView;
    }
}
