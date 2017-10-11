package com.example.marce.treinamentopratico;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AdapterReposit extends RecyclerView.Adapter<AdapterReposit.HolderReposit>{
    private AppCompatActivity activity;
    private List<Repos> listReposit;
    private AdapterReposit.HolderReposit holderReposit;


    public AdapterReposit(List<Repos> listReposit, AppCompatActivity activity) {
        this.listReposit = listReposit;
        this.activity = activity;
    }

    //--------------------------------------------------------- ( METODOS )
    @Override
    public HolderReposit onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_reposit, parent, false);
        HolderReposit holderReposit = new HolderReposit(view);
        return holderReposit;
    }

    @Override
    public void onBindViewHolder(HolderReposit holder, int position) {
        final Repos repos = listReposit.get(position);

        holder.txtNomeReposit.setText(repos.getName());
        holder.txtUrlReposit.setText(repos.getUrl());

        holder.lineraReposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("name",repos.getName());
                bundle.putString("id",Long.toString(repos.getId()));
                bundle.putString("url",repos.getUrl());

                FragReposSelected fragReposSelected = new FragReposSelected();
                fragReposSelected.setArguments(bundle);

                ChangeFragments.trocaFrag((AppCompatActivity) activity, fragReposSelected, R.id.local_main);
            }
        });

    }


    @Override
    public int getItemCount() {
        return listReposit.size();
    }

    //--------------------------------------------------------- ( VIEW HOLDER )
    public class HolderReposit extends RecyclerView.ViewHolder {
        public TextView txtNomeReposit;
        public TextView txtUrlReposit;
        public LinearLayout lineraReposit;

        public HolderReposit(View itemView) {
            super(itemView);

            txtNomeReposit = (TextView)itemView.findViewById(R.id.txt_nome_reposit);
            txtUrlReposit = (TextView) itemView.findViewById(R.id.txt_url_reposit);

            lineraReposit = (LinearLayout)itemView.findViewById(R.id.linear_reposit);        }
    }

}
