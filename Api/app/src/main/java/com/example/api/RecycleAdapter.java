package com.example.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    Context context;
    ArrayList<layout> list;

    RecycleAdapter(Context context, ArrayList<layout> list){
        this.context=context;
        this.list=list;

    }
    @NonNull
    @Override




    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout,parent,false);


        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titles.setText(list.get(position).title);
        holder.posts.setText(list.get(position).body);

    }

    @Override
    public int getItemCount() {
        return list.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titles,posts;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titles=itemView.findViewById(R.id.title);
            posts=itemView.findViewById(R.id.body);
        }
    }
}
