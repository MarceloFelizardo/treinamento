package com.example.marce.treinamentopratico;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragAccount  extends Fragment{

    EditText edtYourEmail, edtCreatePassword, edtConfirmPassword;
    Button btnCreateAccount;
    TextView txtTermsService, txtPrivacyPolicy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_account, parent, false);

        edtYourEmail = (EditText)rootView.findViewById(R.id.edt_your_email);
        edtCreatePassword = (EditText)rootView.findViewById(R.id.edt_create_password);
        edtConfirmPassword = (EditText)rootView.findViewById(R.id.edt_confirm_password);
        btnCreateAccount = (Button)rootView.findViewById(R.id.btn_account);
        txtTermsService = (TextView)rootView.findViewById(R.id.txt_terms_service);
        txtPrivacyPolicy = (TextView)rootView.findViewById(R.id.txt_privacy_policy);

        return rootView;
    }

}
