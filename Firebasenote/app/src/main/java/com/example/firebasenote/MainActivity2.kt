package com.example.firebasenote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebasenote.databinding.ActivityMain2Binding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import java.util.Collections

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy {
        ActivityMain2Binding.inflate(layoutInflater)
    }
    var itemlist=ArrayList<user>()
    lateinit var adapter:rvadapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvrecycler.layoutManager=LinearLayoutManager(this)
        adapter=rvadapter(itemlist)
        binding.rvrecycler.adapter=adapter
        binding.rvrecycler.setHasFixedSize(true)



        Firebase.database.reference.child("Note").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

    for (data in snapshot.children) {
        val list = data.getValue(user::class.java)


        itemlist.add(list!!)


}


            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity2, "data no", Toast.LENGTH_SHORT).show()

            }

        })

    }
}
//
//listhistory1.add(data!!)
//
//}
//Collections.reverse(listhistory1)
//coincategory.addAll(listhistory1)
