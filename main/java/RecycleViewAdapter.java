package com.example.demo_AppDocBao;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.TextureView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.demo.model.Item;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{
    private Context context;
    private List<Item> list;

    public RecycleViewAdapter(Context context, List<Item> list) {
        this.context = context;
        this.list = list;
    }
    public List<Item> getItems(){
            return list;
    }
    public Item getItem(int positon){
        return list.get(positon);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item i = list.get(position);
        holder.title.setTag(i.getTitle());
        holder.pubDate.setTag(i.getPubDate());
        holder.desc.setTag(i.getDescription());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                String link = i.getLink();
                intent.putExtra("link", link);
                context.startActivity(intent);
            };
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextureView title, desc, pubDate;
        private CardView cardView;
        public ViewHolder(@NonNull View view){
            super(view);
            title=view.findViewById(R.id.tvTitle);
            desc=view.findViewById(R.id.tvDesc);
            pubDate=view.findViewById(R.id.tvPubDate);
            cardView=view.findViewById(R.id.cardView);

        }

    }
}
