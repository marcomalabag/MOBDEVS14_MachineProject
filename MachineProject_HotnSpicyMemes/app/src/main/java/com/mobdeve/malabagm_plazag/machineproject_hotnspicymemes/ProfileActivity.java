package com.mobdeve.malabagm_plazag.machineproject_hotnspicymemes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import Accounts.AccountFireBase;
import Accounts.account;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView Username;
    private EditText Bio;
    private Button Edit;
    private AccountFireBase accountFireBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.accountFireBase = new AccountFireBase();
        this.Username = findViewById(R.id.activity_profile_tv_Username);
        this.Bio = findViewById(R.id.activity_profile_et_Bio);
        this.Edit = findViewById(R.id.activity_profile_btn_edit);

        Intent username = getIntent();
        if(username.getParcelableExtra(MemeActivity.ACCOUNT_TAG) != null){
            account curentAccount = username.getParcelableExtra(MemeActivity.ACCOUNT_TAG);
            this.Username.setText(curentAccount.getUsername());
            this.Bio.setText(curentAccount.getBios());
        }

        this.Edit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_profile_btn_edit:
                this.accountFireBase.UpdateBios(this.Username.getText().toString(), this.Bio.getText().toString());
                break;
            default:
                break;
        }
    }

    public void Edit() {
        Intent intent = new Intent(ProfileActivity.this, EditActivity.class);
        startActivity(intent);
    }
}