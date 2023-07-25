package com.example.firebasenote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasenote.databinding.ActivityMainBinding
import com.example.firebasenote.databinding.RecyclerlayoutBinding

class rvadapter(var itemlist:ArrayList<user>): RecyclerView.Adapter<rvadapter.mycategoryviewholder>() {



    class mycategoryviewholder(var binding: RecyclerlayoutBinding) :RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mycategoryviewholder {

    return mycategoryviewholder(RecyclerlayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {return itemlist.size
    }

    override fun onBindViewHolder(holder: mycategoryviewholder, position: Int) {
        holder.binding.textView.text=itemlist.get(position).data


    }
}