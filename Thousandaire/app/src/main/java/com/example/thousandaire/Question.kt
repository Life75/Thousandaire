package com.example.thousandaire

import androidx.annotation.StringRes

data class Question (@StringRes var questionTextID: Int, var answerID: Int, var choiceIds: List<Int>, var amount: Int)
