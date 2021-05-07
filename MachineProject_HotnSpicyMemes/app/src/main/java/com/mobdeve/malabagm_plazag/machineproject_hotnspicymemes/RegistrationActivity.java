package com.mobdeve.malabagm_plazag.machineproject_hotnspicymemes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.accounts.Account;

import Accounts.account;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText username, password, ConfirmPassword, bios, email;
    private account NewAccount;


    public void RegisterAccount(){
        if(this.password.getText().toString().equals(this.ConfirmPassword.getText().toString())){
            this.NewAccount = new account(this.username.getText().toString(), this.password.getText().toString(),
                    this.email.getText().toString(), this.bios.getText().toString());
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        this.username = findViewById(R.id.activity_registration_et_Username1);
        this.password = findViewById(R.id.activity_registration_et_Password1);
        this.ConfirmPassword = findViewById(R.id.activity_registration_et_ConfirmPassword1);
        this.bios = findViewById(R.id.activity_registration_et_Bios);
        this.email = findViewById(R.id.activity_registration_et_Email);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
}