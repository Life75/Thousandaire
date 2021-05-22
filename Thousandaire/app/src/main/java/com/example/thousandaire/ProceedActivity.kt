package com.example.thousandaire

import android.content.Context
import android.content.Intent
import android.graphics.ColorSpace.get
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_win.*



private var CURRENT_MONEY = "CURRENT_MONEY"
private var CURRENT_INDEX = "CURRENT_INDEX"
private var CURRENT_INDEX_MAX = 6

class ProceedActivity : AppCompatActivity() {
    private lateinit var correctTextView : TextView
    private lateinit var goButton: Button
    private lateinit var quitButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)

        var currentMoney = intent.getIntExtra(CURRENT_MONEY, 0)
        var currentIndex = intent.getIntExtra(CURRENT_INDEX, 0)


        goButton = findViewById(R.id.goButton)
        quitButton = findViewById(R.id.quitButton)
        correctTextView = findViewById(R.id.correctTextView)

        var moneyMessage = "Correct! You have earned $${currentMoney}. Would you care to try for $${currentMoney+100}"
        correctTextView.setText(moneyMessage)


        goButton.setOnClickListener { view : View ->

            if (currentIndex == CURRENT_INDEX_MAX)
            {
                var intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("CURRENT_MONEY", currentMoney)
                startActivity(intent)
                finish()
            }
            else
            finish()
        }

        quitButton.setOnClickListener { view: View ->
            var intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("CURRENT_MONEY", currentMoney)
            startActivity(intent)
            finish()
            System.exit(0)

        }



    }



}



