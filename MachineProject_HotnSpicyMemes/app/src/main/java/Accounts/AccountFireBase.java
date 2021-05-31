package Accounts;
import android.accounts.Account;
import android.os.Parcel;
import android.util.Log;


import androidx.annotation.NonNull;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AccountFireBase implements ValueEventListener{

    private account NewAccount;
    private DatabaseReference firebaseDatabase;
    private DatabaseReference ref;
    private FirebaseAuth auth;
    private List<account> accountList = new ArrayList<account>();

    private String TestUsername;
    private String TestPassword;
    private account currentAccount = null;
    private int state = 9;

    public AccountFireBase(){
        this.firebaseDatabase = FirebaseDatabase.getInstance().getReference();
        this.ref = this.firebaseDatabase.child("Accounts");

    }

    public void addNewAccount(account Account){
        NewAccount = Account;
        this.ref.push().setValue(NewAccount);

    }

    public void UpdateBios(String Account, String Bios){
        Query accountQ  = this.ref.orderByChild("username").equalTo(Account);

    }

    public void getAccounts(){
        this.ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                accountList.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keynode : snapshot.getChildren()){
                    keys.add(keynode.getKey());
                    account Acc = keynode.getValue(account.class);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        
    }

    public account getCurrentAccount(){
        return this.currentAccount;
    }

    public int checkAccount(String username, String Password){
        this.TestUsername = username;
        this.TestPassword = Password;
        Query accountQ = this.ref.orderByChild("username").equalTo(this.TestUsername);
        accountQ.addListenerForSingleValueEvent(this);

        return this.state;
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        if(!snapshot.exists()){
            this.state = 0;
        }
        else{
            for(DataSnapshot getPassword: snapshot.getChildren()){
                if(!getPassword.getValue(account.class).getPassword().equals(this.TestPassword)){
                    this.state = 1;
                }
                else {
                    this.currentAccount = getPassword.getValue(account.class);
                    this.state = 2;
                }
            }

        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
}
