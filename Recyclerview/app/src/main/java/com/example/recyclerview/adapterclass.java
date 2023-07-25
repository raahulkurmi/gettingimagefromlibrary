package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class adapterclass extends RecyclerView.Adapter<adapterclass.ViewHolder> {
    Context context;
    ArrayList<Contactmodel> Name;
    private int lastposition=-1;
    adapterclass (Context context, ArrayList<Contactmodel> Name){
        this.context=context;
        this.Name=Name;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

          View view=  LayoutInflater.from(context).inflate(R.layout.mylayout,parent,false);
          ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgcontact.setImageResource(Name.get(position).img);
        holder.txtname.setText(Name.get(position).name);
        holder.txtnumber.setText(Name.get(position).number);


        setAnimation(holder.itemView,position);



    }


    @Override
    public int getItemCount() {
        return Name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtname,txtnumber;
        ImageView imgcontact;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname=itemView.findViewById(R.id.name);
            txtnumber=itemView.findViewById(R.id.number);
            imgcontact=itemView.findViewById(R.id.img);



        }

    }
   private void setAnimation(View ViewtoAnimate,int position){
        if(position>lastposition) {
            Animation slidein = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            ViewtoAnimate.startAnimation(slidein);
            lastposition=position;
        }


   }
}
