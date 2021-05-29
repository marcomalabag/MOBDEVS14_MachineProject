package com.mobdeve.malabagm_plazag.machineproject_hotnspicymemes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MemeActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView Username;
    private Button Upload;
    public static String USERNAME_TAG = "USERNAME_TAG";
    public static String BIO_TAG = "BIO_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme);

        this.Username = findViewById(R.id.activity_meme_tv_Username);
        this.Upload = findViewById(R.id.activity_meme_btn_upload);

        Intent username = getIntent();
        if(username.getStringExtra(MainActivity.NAME_TAG) != null){
            String Username = username.getStringExtra(MainActivity.NAME_TAG);
            this.Username.setText(Username);
        }

        this.Upload.setOnClickListener(this);

        this.Username.setOnClickListener(this);
    }

    public void Upload(){
        Intent intent = new Intent(MemeActivity.this, UploadMeme.class);
        intent.putExtra(USERNAME_TAG, this.Username.getText().toString());
        startActivity(intent);
    }

    public void Profile() {
        Intent intent = new Intent(MemeActivity.this, ProfileActivity.class);
        intent.putExtra(USERNAME_TAG, this.Username.getText().toString());
        //intent.putExtra(BIO_TAG, this.)
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_meme_btn_upload:
                Upload();
                break;
            case R.id.activity_meme_tv_Username:
                Profile();
                break;
            default:
                break;
        }
    }
}