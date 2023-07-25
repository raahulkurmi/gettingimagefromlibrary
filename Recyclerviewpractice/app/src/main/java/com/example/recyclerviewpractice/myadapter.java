package com.example.recyclerviewpractice;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.ViewHolder>



{
    Context context;
    ArrayList<layoutitem> list;

    myadapter(Context context,ArrayList<layoutitem> list){
        this.context=context;
        this.list=list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(list.get(position).img);
        holder.txtname.setText(list.get(position).name);
        holder.txtnumber.setText(list.get(position).number);
        holder.llinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(context);

                dialog.setContentView(R.layout.activity_updatelayout);

                EditText entname = dialog.findViewById(R.id.entname);

                EditText entcontact = dialog.findViewById(R.id.entcontact);

                Button submit = dialog.findViewById(R.id.submit);

                TextView txt=dialog.findViewById(R.id.title);

                txt.setText("update");

                submit.setText("Update");

                entname.setText(list.get(position).name);

                entcontact.setText(list.get(position).number);



                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "",number="";
                        if(!entname.getText().toString().equals("")){
                            name=entname.getText().toString();

                        }else {
                            Toast.makeText(context,"enter the name",Toast.LENGTH_SHORT).show();
                        }
                        if(!entcontact.getText().toString().equals("")) {
                            number = entcontact.getText().toString();
                        }else {
                            Toast.makeText(context,"enter the contact",Toast.LENGTH_SHORT).show();

                        }
                        list.set(position,new layoutitem(name,number));
                        notifyItemChanged(position);
                        dialog.dismiss();

                    }
                });
                dialog.show();
            }
        });
        holder.llinear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context).
                        setTitle("Delete Message").
                        setMessage("are you sure you want to delete").
                        setIcon(R.drawable.ic_launcher_background).
                        setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                list.remove(position);
                                notifyItemRemoved(position);

                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                            }
                        });
                builder.show();

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtname,txtnumber;
        LinearLayout llinear;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            txtname=itemView.findViewById(R.id.name);
            txtnumber=itemView.findViewById(R.id.number);
            llinear=itemView.findViewById(R.id.llinear);

        }
    }
}

