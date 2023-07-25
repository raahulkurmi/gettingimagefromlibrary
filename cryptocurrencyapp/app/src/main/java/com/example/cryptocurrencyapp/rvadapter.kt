package com.example.cryptocurrencyapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrencyapp.databinding.RvlayoutBinding

class rvadapter(var datalist:ArrayList<rvdataclass>): RecyclerView.Adapter<rvadapter.mycustomadapter>() {
    class mycustomadapter(var binding: RvlayoutBinding):RecyclerView.ViewHolder(binding.root)  {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mycustomadapter {
       return mycustomadapter(RvlayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: mycustomadapter, position: Int) {
            holder.binding.Symobol.text=datalist[position].symbol
        holder.binding.price.text=datalist[position].price
        holder.binding.name.text=datalist[position].name

    }
}