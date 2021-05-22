package com.example.thousandaire

import android.app.Activity
import android.content.Intent
import android.icu.text.StringSearch
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.sql.Types.NULL


class MainActivity : AppCompatActivity() {
    var game = Game()
    var currentMoney = 0
    var amount = 100
    var currentQuestionData : Question = game.addQuestion(R.string.questionMickey, R.string.pluto, choices = listOf(1), amount =100 ) //initializing
    //sets up the different questions and adds them to the listOf questions
    private fun changingIndex() {
        game.proceedToNextQuestion()
        if(game.currentQuestionIndex == 0)
        {
            var choices = listOf<Int>(
                R.string.pluto,
                R.string.goofy,
                R.string.minnie,
                R.string.daisy
            )

            currentQuestionData = game.addQuestion(R.string.questionMickey, R.string.pluto,choices,amount )
            question.add(currentQuestionData)
            //falseButtonOne.setText()
        }
        if(game.currentQuestionIndex == 1)
        {
            var choices = listOf<Int>(
                R.string.jupiter,
                R.string.mars,
                R.string.earth,
                R.string.venus
            )

            currentQuestionData = game.addQuestion(R.string.questionSolarSystem, R.string.jupiter, choices, amount)
            question.add(currentQuestionData)
        }
        if(game.currentQuestionIndex == 2)
        {
            var choices = listOf<Int>(
                R.string.seven,
                R.string.six,
                R.string.two,
                R.string.eight
            )

            currentQuestionData = game.addQuestion(R.string.questionShipwrecked, R.string.seven, choices, amount)
            question.add(currentQuestionData)
        }
        if(game.currentQuestionIndex == 3)
        {
            var choices = listOf<Int>(
                R.string.E,
                R.string.Tc,
                R.string.O,
                R.string.Fe
            )

            currentQuestionData = game.addQuestion(R.string.questionTable, R.string.E, choices, amount)
            question.add(currentQuestionData)
        }

        if(game.currentQuestionIndex == 4)
        {
            var choices = listOf<Int>(
                R.string.malta,
                R.string.latvia,
                R.string.estonia,
                R.string.croatia
            )

            currentQuestionData = game.addQuestion(R.string.questionEuro, R.string.malta, choices, amount)
            question.add(currentQuestionData)
        }
        if(game.currentQuestionIndex == 5)
        {
            var choices = listOf<Int>(
                R.string.oneHundred,
                R.string.one,
                R.string.ten,
                R.string.twoHundred
            )

            currentQuestionData = game.addQuestion(R.string.questionSun, R.string.oneHundred, choices, amount)
            question.add(currentQuestionData)
        }

        questionTextView.setText(currentQuestionData.questionTextID)

    }

//creating buttons
    private lateinit var trueButton: Button
    private lateinit var falseButtonOne: Button
    private lateinit var falseButtonTwo: Button
    private lateinit var falseButtonThree: Button
    private lateinit var questionTextView: TextView


    private var question = mutableListOf<Question>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.trueButton)
        falseButtonOne = findViewById(R.id.falseButtonOne)
        falseButtonTwo = findViewById(R.id.falseButtonTwo)
        falseButtonThree = findViewById(R.id.falseButtonThree)
        questionTextView = findViewById(R.id.questionTextView)
        questionTextView.setText(R.string.questionMickey)


//If this button is clicked with the true answer attached then it is true and the player is able to proceed
        trueButton.setOnClickListener { view: View ->
            currentMoney += currentQuestionData.amount

            if(game.isFinalQuestion())
            {
                var intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("CURRENT_MONEY", currentMoney)
                startActivity(intent)
                finish()
                finish()
                finishAffinity()
                System.exit(0)
            }
            else
            {
                changingIndex()
//setting up for the next question and WinActivity screen
                var intent = Intent(this, ProceedActivity::class.java)
                intent.putExtra("CURRENT_MONEY", currentMoney)
                intent.putExtra("CURRENT_INDEX", game.currentQuestionIndex)
                startActivityForResult(intent, currentMoney)
                trueButton.setText(currentQuestionData.answerID)
                falseButtonOne.setText(currentQuestionData.choiceIds[1])
                falseButtonTwo.setText(currentQuestionData.choiceIds[2])
                falseButtonThree.setText(currentQuestionData.choiceIds[3])
            }


        }


        falseButtonOne.setOnClickListener { view: View ->
        failed()


        }

        falseButtonTwo.setOnClickListener { view: View ->
        failed()


        }

        falseButtonThree.setOnClickListener { view: View ->
            failed()
        }







    }

//failed sending to LoseActivity screen and forcing the player to quit the game from that screen closing the rest of the activities
    fun failed()
    {
        var intent = Intent(this,GameOverActivity::class.java)
        startActivity(intent)
        finish()
        finish()
    }
}

