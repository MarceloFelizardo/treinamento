package com.example.marce.treinamentopratico;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.marce.treinamentopratico.GitHubServiceUser.URL_BaseUser;

public class FragSelected extends Fragment{
    public CircleImageView fotoSel;
    public TextView txtIDSel, txtLoginSel, txtTypeSel, txtBioSel;
    public Button btnReposit;
    public User user;
    private String usuarioAtual;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_selected, container, false);

        fotoSel = (CircleImageView)rootView.findViewById(R.id.foto_sel);
        txtIDSel = (TextView)rootView.findViewById(R.id.txtID_sel);
        txtLoginSel = (TextView)rootView.findViewById(R.id.txtLogin_sel);
        txtTypeSel = (TextView)rootView.findViewById(R.id.txtType_sel);
        txtBioSel = (TextView)rootView.findViewById(R.id.txtBio_sel);
        btnReposit = (Button)rootView.findViewById(R.id.btn_reposit);

        //Receber nome do usuário atual
        usuarioAtual = getArguments().getString("nome");

        // Trata Retrofit e GitHub
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BaseUser)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubServiceUser serviceUser = retrofit.create(GitHubServiceUser.class);
        Call<User> requestCatalog = serviceUser.dataUser(usuarioAtual);

        requestCatalog.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getActivity(), "Erro codigo: " + response.code(),
                            Toast.LENGTH_SHORT).show();
                }else{
                    //List<User> listUsers = new ArrayList<User>();
                    User user = new User();
                    user = response.body();

                    Glide.with(getActivity()).load(user.getAvatar_url()).into(fotoSel);
                    txtLoginSel.setText(user.getLogin());
                    txtIDSel.setText(Long.toString(user.getId()));
                    txtTypeSel.setText(user.getType());
                    txtBioSel.setText(user.getBio());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getActivity(), "Erro: " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnReposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("nome2",usuarioAtual);

                FragListReposit fragListReposit = new FragListReposit();
                fragListReposit.setArguments(bundle);

                ChangeFragments.trocaFrag((AppCompatActivity) getActivity(), fragListReposit, R.id.local_main);
            }
        });


        return rootView;
    }
}
