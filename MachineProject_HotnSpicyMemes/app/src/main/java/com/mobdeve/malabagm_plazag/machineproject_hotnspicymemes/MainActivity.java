package com.mobdeve.malabagm_plazag.machineproject_hotnspicymemes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Accounts.AccountFireBase;
import Accounts.account;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText Username, Password;
    private Button Login, Register;
    private AccountFireBase accountFireBase;
    private RecyclerView myRecyclerView;
    public static String ACCOUNT_TAG = "ACCOUNT_TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username = findViewById(R.id.activity_main_et_UsernameInput1);
        Password = findViewById(R.id.activity_main_et_PasswordInput1);

        Login = findViewById(R.id.activity_main_btn_Login);
        Register = findViewById(R.id.activity_main_btn_Registration);

        Login.setOnClickListener(this);
        Register.setOnClickListener(this);
        this.accountFireBase = new AccountFireBase();

    }

    public void toMemePage(){
        if(accountFireBase.checkAccount(Username.getText().toString(), Password.getText().toString()) == 0){
            Toast.makeText(this, "Account does not exist", Toast.LENGTH_SHORT).show();
        }
        else{
            if(accountFireBase.checkAccount(Username.getText().toString(), Password.getText().toString()) == 1){
                Toast.makeText(this, "Password is incorrect", Toast.LENGTH_SHORT).show();
            }
            else if(accountFireBase.checkAccount(Username.getText().toString(), Password.getText().toString()) == 2){
                if(accountFireBase.getCurrentAccount() != null){
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MemeActivity.class);
                    account currentAccount = accountFireBase.getCurrentAccount();
                    intent.putExtra(ACCOUNT_TAG, currentAccount);
                    startActivity(intent);
                }
            }
        }

    }

    public void toRegistration(){
        Intent i = new Intent(MainActivity.this, RegistrationActivity.class);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_main_btn_Login:
                toMemePage();
                break;
            case R.id.activity_main_btn_Registration:
                toRegistration();
                break;
            default:
                break;
        }
    }
}