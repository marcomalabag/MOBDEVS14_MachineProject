package Accounts;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

public class AccountFireBase {

    private account NewAccount;
    DatabaseReference ref;

    public AccountFireBase(){

        this.ref = FirebaseDatabase.getInstance().getReference().child("Accounts");
    }

    public void addNewAccount(account Account){
        NewAccount = Account;
        this.ref.push().setValue(NewAccount);
        this.ref.getKey();
    }

    public void getAccounts(){
        this.ref.child("-MZzbzJHNgksC0_CFE8e").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    
                }
            }
        });
    }
}
