package com.mobdeve.malabagm_plazag.machineproject_hotnspicymemes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText Username, Password;
    private Button Login, Register;


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

    }

    public void toMemePage(){

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
            case R.id.activity_main_btn_Registration:
                toRegistration();
        }
    }
}