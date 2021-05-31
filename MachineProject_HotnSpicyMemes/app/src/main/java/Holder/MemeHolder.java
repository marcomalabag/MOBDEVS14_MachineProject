package Holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.mobdeve.malabagm_plazag.machineproject_hotnspicymemes.R;

public class MemeHolder extends RecyclerView.ViewHolder {

    public TextView Name, Uploader, Date, Category;
    public ImageView Meme;
    public Context mContext;

    public MemeHolder(@NonNull View itemView) {
        super(itemView);

        this.Name = itemView.findViewById(R.id.tv_memeName);
        this.Uploader = itemView.findViewById(R.id.tvmemeUploader);
        this.Date = itemView.findViewById(R.id.tvmemeDate);
        this.Category = itemView.findViewById(R.id.tvmemeCategory);
        this.Meme = itemView.findViewById(R.id.iv_memeImage);
    }

    public void setmContext(Context mContext){
        this.mContext = mContext;
    }

    public void setName(String Name){
        this.Name.setText(Name);
    }

    public void setUploader(String Uploader){
        this.Uploader.setText(Uploader);
    }

    public void setDate(String Date){
        this.Date.setText(Date);
    }

    public void setCategory(String Category){
        this.Category.setText(Category);
    }

    public void setMeme(int meme){
        this.Meme.setImageResource(meme);
    }
}
