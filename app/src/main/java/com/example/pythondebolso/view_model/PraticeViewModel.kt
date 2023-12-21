package com.example.pythondebolso.view_model

import androidx.lifecycle.ViewModel

class PraticeViewModel : ViewModel(){
    private val rightAnswers = mapOf(
        "question1" to "Sim",
        "Question2" to "Não",
    )

    private val questionStates = mutableMapOf<String, Boolean>()

    fun check(userAnswers: Map<String, String>) {
        var pontuacao = 0

        for ((question, answer) in rightAnswers) {
            val user = userAnswers[question]

            val respostaCorreta = user == answer
            questionStates[question] = respostaCorreta

            if (user == answer) {
                pontuacao++
            }
        }
    }

    fun getQuestionState(question: String): Boolean {
        return questionStates[question] ?: false
    }
}