package com.mobdeve.malabagm_plazag.machineproject_hotnspicymemes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import Accounts.account;
import Adapter.MemeAdapter;
import Meme.Meme;
import Meme.MemeFireBase;


public class MemeActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView Username;
    private Button Upload;
    private account currentAccount = null;
    private MemeFireBase memeFireBase;
    private ArrayList<Meme> MemeList;
    private RecyclerView recyclerView;
    public static String USERNAME_TAG = "USERNAME_TAG";
    public static String BIO_TAG = "BIO_TAG";
    public static String ACCOUNT_TAG = "ACCOUNT_TAG";
    private MemeAdapter memeAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme);
        this.memeFireBase = new MemeFireBase();
        this.Username = findViewById(R.id.activity_meme_tv_Username);
        this.Upload = findViewById(R.id.activity_meme_btn_upload);
        this.MemeList = new ArrayList<Meme>();
        this.recyclerView = findViewById(R.id.activity_meme_rv_memes);
        Intent getAccount = getIntent();
        if(getAccount.getParcelableExtra(MainActivity.ACCOUNT_TAG) != null){
            this.currentAccount = getAccount.getParcelableExtra(MainActivity.ACCOUNT_TAG);
            this.Username.setText(this.currentAccount.getUsername());
        }

        this.Upload.setOnClickListener(this);

        this.Username.setOnClickListener(this);
        setRecyclerView();
    }

    public void setRecyclerView(){
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //this.MemeList = this.memeFireBase.getMemes();
        this.MemeList.add(new Meme("Caption", "Funny", "11-14-20", "Marco,", 2131230868));
        this.MemeList.add(new Meme("This is a caption", "Funny", "11-14-20", "Marco,", 2131230868));
        this.MemeList.add(new Meme("This is a caption", "Funny", "11-14-20", "Marco,", R.drawable.ripwindows7));
        this.memeAdapter = new MemeAdapter(this.MemeList, this);
        this.recyclerView.setAdapter(this.memeAdapter);


    }

    public void Upload(){
        if(this.currentAccount != null){
            Intent intent = new Intent(MemeActivity.this, UploadMeme.class);
            intent.putExtra(ACCOUNT_TAG, this.currentAccount);
            startActivity(intent);
        }
    }

    public void Profile() {
        if(this.currentAccount != null){
            Intent intent = new Intent(MemeActivity.this, ProfileActivity.class);
            intent.putExtra(ACCOUNT_TAG, this.currentAccount);
            startActivity(intent);
        }

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