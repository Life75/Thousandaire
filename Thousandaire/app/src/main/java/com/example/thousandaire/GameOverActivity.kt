package com.example.thousandaire

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class GameOverActivity : AppCompatActivity() {

    private lateinit var quitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lose)

        quitButton = findViewById(R.id.quitButton)

        quitButton.setOnClickListener { view : View ->
            finishAffinity()
            finish();
            System.exit(0);
            }
        }
    }





