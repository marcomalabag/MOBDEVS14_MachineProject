package com.mobdeve.malabagm_plazag.machineproject_hotnspicymemes;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import Accounts.account;
import Meme.MemeFireBase;
import Meme.Meme;

public class UploadMeme extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    private Spinner Category;
    private String SelectedCategory = "";
    private String Uploader;
    private MemeFireBase memeFireBase;
    private Random random;
    private ImageView displayUpload;
    private Button Upload;
    private EditText Caption;
    private int currentImage;

    private int Drawables[] = {R.drawable.meme1, R.drawable.meme2, R.drawable.ripwindows7, R.drawable.zoomdies};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_meme);
        this.Category = findViewById(R.id.spinner_catergory);
        this.memeFireBase = new MemeFireBase();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.CategorySelection, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.Category.setAdapter(adapter);
        this.Category.setOnItemSelectedListener(this);
        this.Upload = findViewById(R.id.btn_Upload);
        this.Upload.setOnClickListener(this);
        this.displayUpload = findViewById(R.id.iv_displayupload);
        this.Caption = findViewById(R.id.et_Caption);
        Intent getAccount = getIntent();
        if(getAccount.getParcelableExtra(MemeActivity.ACCOUNT_TAG) != null){
            account currentAccount = getAccount.getParcelableExtra(MemeActivity.ACCOUNT_TAG);
            this.Uploader = currentAccount.getUsername();
        }

        this.currentImage = randomSelectFromImages(this.Drawables);
        this.displayUpload.setImageResource(this.currentImage);

    }

    public int randomSelectFromImages(int[] data ){
        this.random = new Random();
        return data[this.random.nextInt(data.length)];
    }

    public void UploadMeme(){
        if(this.SelectedCategory != "" && this.Caption.getText().toString() != ""){
            Date c = Calendar.getInstance().getTime();
            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
            String formattedDate = df.format(c);
            this.memeFireBase.AddMeme(new Meme(this.Caption.getText().toString(), this.SelectedCategory, formattedDate, this.Uploader, this.currentImage));
            Toast.makeText(this, "Meme successfully Uploaded", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Missing Field", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_Upload:
                UploadMeme();
                break;
            default:
                break;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                this.SelectedCategory = "";
                break;
            case 1:
                this.SelectedCategory = parent.getItemAtPosition(position).toString();
                break;
            case 2:
                this.SelectedCategory = parent.getItemAtPosition(position).toString();
                break;
            case 3:
                this.SelectedCategory = parent.getItemAtPosition(position).toString();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}