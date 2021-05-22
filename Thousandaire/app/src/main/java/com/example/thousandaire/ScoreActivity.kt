package com.example.thousandaire

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_win.*

private var CURRENT_MONEY = "CURRENT_MONEY"

class ScoreActivity : AppCompatActivity() {

    private lateinit var playOverButton: Button
    private lateinit var quitGameButton: Button
    private lateinit var finalResultText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        var money = intent.getIntExtra(CURRENT_MONEY, 0)
        var finalMessage = "Congratulations!\n You earned $${money}!"

        playOverButton = findViewById(R.id.playOverButton)
        quitGameButton = findViewById(R.id.quitGameButton)
        finalResultText = findViewById(R.id.finalResultText)
        finalResultText.setText(finalMessage)

        playOverButton.setOnClickListener { view: View ->
            var intent = Intent(this, MainActivity::class.java)
            finishAffinity()
            startActivity(intent)
            finish()
        }

        quitGameButton.setOnClickListener { view: View ->
            finishAffinity()
            finish()
            System.exit(0)
        }


    }


}
