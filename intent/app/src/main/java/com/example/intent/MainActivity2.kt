package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.intent.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.setting-> Toast.makeText(this@MainActivity2, "setting", Toast.LENGTH_SHORT).show()
            R.id.hello-> Toast.makeText(this@MainActivity2, "hello", Toast.LENGTH_SHORT).show()
            R.id.logout-> Toast.makeText(this@MainActivity2, "logout", Toast.LENGTH_SHORT).show()



        }



        return true
    }
}