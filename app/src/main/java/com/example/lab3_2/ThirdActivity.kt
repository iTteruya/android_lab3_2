package com.example.lab3_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ThirdActivity: AppCompatActivity() {
    lateinit var toFirstButton: Button
    lateinit var toSecondButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_activity)

        toFirstButton = findViewById(R.id.toFirst)
        toFirstButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
                .putExtra("result", "Third to First")
            setResult(1, intent)
            finish()
        }

        toSecondButton = findViewById(R.id.toSecond)
        toSecondButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
                .putExtra("result", "Third to Second")
            setResult(1, intent)
            finish()
        }

        val aboutMenu = findViewById<BottomNavigationView>(R.id.activity_about)
        aboutMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.about -> {
                    startActivity(Intent(this, AboutActivity::class.java))
                }
            }
            true
        }
    }
}