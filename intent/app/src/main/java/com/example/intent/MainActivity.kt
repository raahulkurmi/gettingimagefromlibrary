package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import com.example.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            showpopup(it)
        }


    }

    private fun showpopup(view :View) {
      val popupMenu=PopupMenu(this,view)
        popupMenu.inflate(R.menu.menu)
        popupMenu.show()
        popupMenu.setOnMenuItemClickListener {item->
            when(item.itemId){
               R.id.setting->{
                   Toast.makeText(this@MainActivity, "setting", Toast.LENGTH_SHORT).show()
                   return@setOnMenuItemClickListener true
               }
                R.id.hello->{
                    Toast.makeText(this@MainActivity, "setting hello", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }

                else -> {
                    Toast.makeText(this@MainActivity, "setting logut", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
            }
        }
    }
}