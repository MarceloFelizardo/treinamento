package com.example.marce.treinamentopratico;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private AppCompatActivity activity;
    private List<User> listUsers;
    private MyViewHolder myViewHolder;


    public MyAdapter(List<User> listUsers, AppCompatActivity activity) {
        this.listUsers = listUsers;
        this.activity = activity;
}
    //--------------------------------------------------------- ( METODOS )
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_modelo, parent, false);
        MyViewHolder myHolder = new MyViewHolder(view);
        return myHolder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final User user = listUsers.get(position);
        holder.txtLogin.setText(user.getLogin());
        holder.txtId.setText(Long.toString(user.getId()));
        holder.txtType.setText(user.getType());

        Glide.with(activity).load(user.getAvatar_url()).into(holder.foto);


        //------------------------------

        holder.linearMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Enviar nome do usuário atual
                Bundle bundle = new Bundle();
                bundle.putString("nome",user.getLogin());
                FragSelected fragSelected = new FragSelected();
                fragSelected.setArguments(bundle);

                ChangeFragments.trocaFrag((AppCompatActivity) activity, fragSelected, R.id.local_main);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listUsers.size();
    }



    //--------------------------------------------------------- ( VIEW HOLDER )
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView txtLogin;
        public TextView txtId;
        public TextView txtType;
        public CircleImageView foto;
        public LinearLayout linearMain;

        public String setUser;

        public MyViewHolder(View view){
            super(view);

            txtLogin = (TextView)view.findViewById(R.id.txtLogin);
            txtId = (TextView)view.findViewById(R.id.txtId);
            txtType = (TextView)view.findViewById(R.id.txtType);
            foto = (CircleImageView)view.findViewById(R.id.foto);

            linearMain = (LinearLayout)view.findViewById(R.id.linear_main);
        }
    }


}
