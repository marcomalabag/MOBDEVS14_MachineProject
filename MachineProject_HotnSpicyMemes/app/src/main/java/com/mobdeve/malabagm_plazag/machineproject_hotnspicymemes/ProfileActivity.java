package com.mobdeve.malabagm_plazag.machineproject_hotnspicymemes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView Username;
    private TextView Bio;
    private Button Edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        this.Username = findViewById(R.id.activity_profile_tv_Username);
        this.Bio = findViewById(R.id.activity_profile_tv_Bio);
        this.Edit = findViewById(R.id.activity_profile_btn_edit);

        Intent username = getIntent();
        if(username.getStringExtra(MemeActivity.USERNAME_TAG) != null){
            String Username = username.getStringExtra(MemeActivity.USERNAME_TAG);
            this.Username.setText(Username);
        }

        this.Edit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_profile_btn_edit:
                Edit();
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