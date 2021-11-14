package com.example.lab3_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var toSecondButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toSecondButton = findViewById(R.id.bnToSecond)
        toSecondButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        val aboutMenu = findViewById<BottomNavigationView>(R.id.nav_view)
        aboutMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.aboutActivity -> {
                    startActivity(Intent(this, AboutActivity::class.java))
                }
            }
            true
        }
    }
}