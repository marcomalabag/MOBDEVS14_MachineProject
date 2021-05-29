package Accounts;

public class account {

    private String Username, password, email, bios;

    public account(){ }

    public account(String Username, String password, String email, String bios){
        this.Username = Username;
        this.password = password;
        this.email = email;
        this.bios = bios;
    }

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
