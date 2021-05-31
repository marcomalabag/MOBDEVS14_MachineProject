package Meme;

import android.os.Parcel;
import android.os.Parcelable;

import Accounts.account;

public class Meme implements Parcelable {

    private String name;
    private String Category;
    private String Date;
    private String Uploader;
    private int Image;

    public Meme(){

    }

    public Meme(String name, String Category, String Date, String Uploader, int Image){
        this.name = name;
        this.Category = Category;
        this.Date = Date;
        this.Uploader = Uploader;
        this.Image = Image;
    }

    public static final Parcelable.Creator<Meme> CREATOR
            = new Parcelable.Creator<Meme>() {
        public Meme createFromParcel(Parcel in) {
            return new Meme(in);
        }

        public Meme[] newArray(int size) {
            return new Meme[size];
        }
    };

    public Meme(Parcel in){
        this.name = in.readString();
        this.Category = in.readString();
        this.Date = in.readString();
        this.Uploader = in.readString();
        this.Image = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.Category);
        dest.writeString(this.Date);
        dest.writeString(this.Uploader);
        dest.writeInt(this.Image);
    }



    public String getName(){
        return this.name;
    }

    public String getCategory(){
        return this.Category;
    }

    public String getDate(){
        return this.Date;
    }

    public String getUploader(){
        return this.Uploader;
    }

    public int getImage(){
        return this.Image;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCategory(String Category){
        this.Category = Category;
    }

    public void setDate(String Date){
        this.Date = Date;
    }

    public void setUploader(String Uploader){
        this.Uploader = Uploader;
    }

    public void setImage(int Image){
        this.Image = Image;
    }


}
