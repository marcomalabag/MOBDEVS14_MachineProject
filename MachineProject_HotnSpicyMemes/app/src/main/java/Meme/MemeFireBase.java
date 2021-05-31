package Meme;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MemeFireBase implements ValueEventListener {

    private DatabaseReference firebaseDatabase;
    private DatabaseReference ref;
    private ArrayList<Meme> memeList;

    public MemeFireBase(){
        this.firebaseDatabase = FirebaseDatabase.getInstance().getReference();
        this.ref = this.firebaseDatabase.child("Memes");
        this.memeList = new ArrayList<Meme>();
    }

    public void AddMeme(Meme newMeme){
        this.ref.push().setValue(newMeme);
    }

    public ArrayList<Meme> getMemes(){
        this.ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                memeList.clear();
                for(DataSnapshot meme : snapshot.getChildren()){
                    Meme newMeme = meme.getValue(Meme.class);
                    memeList.add(newMeme);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return this.memeList;
    }


    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        this.memeList.clear();

        for(DataSnapshot meme : snapshot.getChildren()){

            Meme newMeme = meme.getValue(Meme.class);

            this.memeList.add(newMeme);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
}
