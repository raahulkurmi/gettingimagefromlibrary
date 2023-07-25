package com.example.shaayariapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shaayariapp.databinding.RvItemBinding

class Recyclerviewadapter(var datalist:ArrayList<dataitem>,var context:Context): RecyclerView.Adapter<Recyclerviewadapter.mycustomviewholder>() {
    class mycustomviewholder(val binding: RvItemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mycustomviewholder {
  return mycustomviewholder(RvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: mycustomviewholder, position: Int) {
       holder.binding.textView.text=datalist[position].shyari
    }
}