package com.example.newspaperapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {
    Context context;
    ArrayList<modelclass> modelclassArrayList;

    public adapter(@NonNull Context context, ArrayList<modelclass> modelclassArrayList) {
        this.context = context;
        this.modelclassArrayList = modelclassArrayList;
    }
    @NonNull
    @Override


    public adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recyclelayout,null,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return modelclassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
