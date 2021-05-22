package com.example.thousandaire

import android.provider.Settings.Global.getString
import androidx.lifecycle.ViewModel

private var FINAL_QUESTION_INDEX_NUM = 5

class Game : ViewModel() {
    init {

    }
    private var questions = listOf<String>(
        "What is the largest planet in our solar system?",
        "How many people were originally shipwrecked on Gilligan\\'s Island?",
        "Which of these is not an abbreviation for an element on the periodic table?",
        "The city Valletta is the capital of which European country?",
        "Approximately how many million miles is the Earth from the Sun?"
    )


    var currentQuestionIndex = 1
    var currentQuestionAnswer = 0
    var currentQuestionText = ""
    var nextQuestionAmount = 0

    fun addQuestion(questionText: Int, questionAnswer: Int, choices: List<Int>, amount: Int) : Question{
        var addQuestion = Question(questionText,questionAnswer,choices,amount)

        currentQuestionAnswer = questionAnswer
        return addQuestion
    }

    fun isFinalQuestion(): Boolean {
        return currentQuestionIndex == FINAL_QUESTION_INDEX_NUM
    }

    fun proceedToNextQuestion()
    {
        if(!isFinalQuestion())
        {
            currentQuestionIndex += 1
            return
        }

    }


}


