package com.example.lab3_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class SecondActivity: AppCompatActivity() {

    private lateinit var toFirstButton: Button
    private lateinit var toThirdButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        toFirstButton = findViewById(R.id.bnToFirst)
        toFirstButton.setOnClickListener {
            finish()
        }

        toThirdButton = findViewById(R.id.bnToThird)
        toThirdButton.setOnClickListener {
            startActivityForResult(Intent(this, ThirdActivity::class.java), 1)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val res = data?.getStringExtra("result")
        if (res == "Third to First") {
            finish()
        }
    }

}