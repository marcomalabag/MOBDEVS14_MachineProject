package com.mobdeve.malabagm_plazag.machineproject_hotnspicymemes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.accounts.Account;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import Accounts.AccountFireBase;
import Accounts.account;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText username, password, ConfirmPassword, bios, email;
    private account NewAccount;
    private AccountFireBase accountFireBase = new AccountFireBase();

    private Button Registration;
    private FirebaseAuth auth;

    public void RegisterAccount(){
        Toast toast;
        if(this.password.getText().toString().equals(this.ConfirmPassword.getText().toString())){
            this.NewAccount = new account(this.username.getText().toString(), this.password.getText().toString(),
                    this.email.getText().toString(), this.bios.getText().toString());
            this.accountFireBase.addNewAccount(this.NewAccount);
        }
        else{
            toast = Toast.makeText(getApplicationContext(), "Confirm password and password do not match, please try again.", Toast.LENGTH_SHORT);
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        this.username = findViewById(R.id.activity_registration_et_Username1);
        this.password = findViewById(R.id.activity_registration_et_Password1);
        this.ConfirmPassword = findViewById(R.id.activity_registration_et_ConfirmPassword1);
        this.bios = findViewById(R.id.activity_registration_et_Bios1);
        this.email = findViewById(R.id.activity_registration_et_Email1);
        this.Registration = findViewById(R.id.activity_registration_btn_registration);

        this.Registration.setOnClickListener(this);
        this.auth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_registration_btn_registration:
                RegisterAccount();
        }
    }
}