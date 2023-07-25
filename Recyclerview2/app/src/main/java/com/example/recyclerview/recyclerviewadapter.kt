package com.example.recyclerview

import android.app.Activity
import android.app.AlertDialog
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.RecyclerviewBinding
import kotlin.coroutines.coroutineContext

class recyclerviewadapter(val list:ArrayList<dataclass>): RecyclerView.Adapter<recyclerviewadapter.mycustomadapter>() {
    class mycustomadapter (var binding: RecyclerviewBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mycustomadapter {
    return mycustomadapter(RecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
      return list.size
    }

    override fun onBindViewHolder(holder: mycustomadapter, position: Int) {
        val pos=list[position]
        val currentPosition = holder.adapterPosition
   holder.binding.imageview.setImageResource(pos.image)
        holder.binding.text.text=pos.text
        holder.binding.text.isSelected=true

        holder.binding.layout.setOnLongClickListener {
            val alertDialogBuilder = AlertDialog.Builder(holder.itemView.context)

// Set the title and message of the dialog
            alertDialogBuilder.setTitle("AlertDialog Title")
            alertDialogBuilder.setMessage("This is the message of the AlertDialog")

// Set the positive button and its click listener
            alertDialogBuilder.setPositiveButton("OK") { dialog, _ ->
                    removeItem(position)

    // Return true to indicate that the long click is consume
    dialog.dismiss()
                dialog.dismiss()
            }

// Set the negative button and its click listener
            alertDialogBuilder.setNegativeButton("Cancel") { dialog, _ ->
                // Handle negative button click
                // You can perform any actions here or dismiss the dialog if needed
                dialog.dismiss()
            }

// Create and show the AlertDialog
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
            true

        }







        holder.binding.layout.setOnClickListener {
            Toast.makeText(holder.itemView.context, position.toString(), Toast.LENGTH_SHORT).show()
            val alertDialogBuilder = AlertDialog.Builder(holder.itemView.context)

//            val icon = BitmapFactory.decodeResource(holder.itemView.context.resources,R.drawable.ic_launcher_background)
//            alertDialogBuilder.setIcon(icon)

            alertDialogBuilder.setTitle(list[position].text)
            alertDialogBuilder.setIcon(list[position].image)

// Set the positive button and its click listener
            alertDialogBuilder.setPositiveButton("OK") { dialog, _ ->
                // Handle positive button click
                // You can perform any actions here or dismiss the dialog if needed
                dialog.dismiss()
            }

// Set the negative button and its click listener
            alertDialogBuilder.setNegativeButton("Cancel") { dialog, _ ->
                // Handle negative button click
                // You can perform any actions here or dismiss the dialog if needed
                dialog.dismiss()
            }

// Create and show the AlertDialog
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()

        }


    }
    fun removeItem(position: Int) {
        if (position in 0 until list.size) {
            list.removeAt(position)
            notifyItemRemoved(position)
        }
    }
//    removeItem(position)
//
//    // Return true to indicate that the long click is consumed
//    true
//    dialog.dismiss()
}