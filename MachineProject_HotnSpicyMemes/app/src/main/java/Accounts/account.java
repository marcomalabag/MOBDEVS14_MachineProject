package Accounts;

public class account {

    private String Username, password, email, bios;

    public account(String Username, String password, String email, String bios){
        this.Username = Username;
        this.password = password;
        this.email = email;
        this.bios = bios;
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
