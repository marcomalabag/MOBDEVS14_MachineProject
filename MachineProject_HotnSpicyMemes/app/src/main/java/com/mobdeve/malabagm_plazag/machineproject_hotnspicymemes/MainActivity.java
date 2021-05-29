package com.mobdeve.malabagm_plazag.machineproject_hotnspicymemes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Accounts.AccountFireBase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText Username, Password;
    private Button Login, Register;
    private AccountFireBase accountFireBase = new AccountFireBase();
    private RecyclerView myRecyclerView;
    public static String NAME_TAG = "NAME_TAG";


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
        accountFireBase.getAccounts();

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
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MemeActivity.class);
                intent.putExtra(NAME_TAG, Username.getText().toString());
                startActivity(intent);
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