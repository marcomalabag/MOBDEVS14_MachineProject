package Accounts;

import android.os.Parcel;
import android.os.Parcelable;

public class account implements Parcelable {

    private String Username, password, email, bios;

    public account(){ }

    public account(String Username, String password, String email, String bios){
        this.Username = Username;
        this.password = password;
        this.email = email;
        this.bios = bios;
    }

    public account(Parcel in){
        this.Username = in.readString();
        this.password = in.readString();
        this.email = in.readString();
        this.bios = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Username);
        dest.writeString(this.password);
        dest.writeString(this.email);
        dest.writeString(this.bios);
    }

    public static final Parcelable.Creator<account> CREATOR
            = new Parcelable.Creator<account>() {
        public account createFromParcel(Parcel in) {
            return new account(in);
        }

        public account[] newArray(int size) {
            return new account[size];
        }
    };

    public void setUsername(String username){
        this.Username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setBios(String bios){
        this.bios = bios;
    }

    public void setEmail(String Email){
        this.email = Email;
    }

    public String getUsername(){
        return this.Username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getEmail(){
        return this.email;
    }

    public String getBios(){
        return this.bios;
    }



}
