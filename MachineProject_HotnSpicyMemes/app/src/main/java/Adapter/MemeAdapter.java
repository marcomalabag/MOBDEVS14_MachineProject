package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Holder.MemeHolder;
import Meme.Meme;
import com.mobdeve.malabagm_plazag.machineproject_hotnspicymemes.R;

public class MemeAdapter extends RecyclerView.Adapter<MemeHolder>  {

    private Context mContext;
    private ArrayList<Meme> memeList = new ArrayList<Meme>();

    public MemeAdapter(ArrayList<Meme> memeList, Context mContext){
        this.memeList = memeList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MemeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.mContext);
        View view = inflater.inflate(R.layout.meme_item, parent, false);

        MemeHolder memeHolder = new MemeHolder(view);
        memeHolder.setmContext(this.mContext);
        return memeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MemeHolder holder, int position) {
        holder.setName(memeList.get(position).getName());
        holder.setCategory(memeList.get(position).getCategory());
        holder.setDate(memeList.get(position).getDate());
        holder.setUploader(memeList.get(position).getUploader());
        holder.setMeme(memeList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return memeList.size();
    }
}
