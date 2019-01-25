package com.sopt.ch7

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast

class Ch7_1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ch7_1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

       // menuInflater.inflate(R.menu.mymenu,menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.menu_apple -> {
                Toast.makeText(this,"사과",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_grape -> {
                Toast.makeText(this,"포도",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_banana -> {
                Toast.makeText(this,"바나나",Toast.LENGTH_SHORT).show()
                return true
            }
            else->
            return super.onOptionsItemSelected(item)
        }

    }
}
