package com.example.marce.treinamentopratico;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marce.treinamentopratico.ChangeFragments;
import okhttp3.Credentials;

import static com.example.marce.treinamentopratico.R.id.dlg_btn_cancel;

public class FragLogin extends Fragment implements View.OnClickListener{

    EditText edtUserName, edtPassword;
    Button btnLogin, btnAccount;
    TextView txtForgot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_login, parent, false);

        edtUserName = (EditText)rootView.findViewById(R.id.edt_username);
        edtPassword = (EditText)rootView.findViewById(R.id.edt_password);
        btnLogin = (Button)rootView.findViewById(R.id.btn_login);
        btnAccount = (Button)rootView.findViewById(R.id.btn_account);
        txtForgot = (TextView)rootView.findViewById(R.id.txt_forgot);

        btnAccount.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        txtForgot.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:{
                //Credentials.basic(username, password);

                Intent intent = new Intent(getActivity(),MainActivity.class);
                getActivity().startActivity(intent);
                break;
            }
            case R.id.btn_account:{
               ChangeFragments.trocaFrag((AppCompatActivity) getActivity(), new FragAccount(),R.id.local_login);
                break;
            }
            case R.id.txt_forgot:{
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_password);
                dialog.show();

                Button btn_cancel = (Button)dialog.findViewById(dlg_btn_cancel);
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                break;
            }
        }
    }



}
