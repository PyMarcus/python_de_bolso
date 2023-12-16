package com.example.pythondebolso

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.View.OnClickListener
import com.example.pythondebolso.controllers.LearnPercentController
import com.example.pythondebolso.databinding.ActivityIoactivityBinding
import com.example.pythondebolso.models.LearnPercentEntity

class IOActivity : AppCompatActivity(), OnClickListener {

    private lateinit var profileController: LearnPercentController

    private val pythonKeyWords = listOf(
    "False", "None", "True", "and", "as", "assert", "async", "await", "break",
    "class", "continue", "def", "del", "elif", "else", "except", "finally", "for",
    "from", "global", "if", "import", "lambda", "nonlocal", "not",
   "pass", "raise", "return", "try", "while", "with", "yield", "Input", "Print"
    )

    private val text1 = "Input é uma função usada para receber dados do usuário durante a execução " +
            "de um programa. Ela pausa a execução, aguarda a entrada do usuário e retorna a entrada " +
            "como uma string."
    private val text2 = "Print refere-se aos dados que um programa envia de volta ao ambiente " +
            "externo. Pode ser exibido na tela, gravado em um arquivo, enviado pela rede, etc. " +
            "A saída representa os resultados do processamento do programa."

    private lateinit var binding: ActivityIoactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIoactivityBinding.inflate(layoutInflater)

        setContentView(binding.root)

        this.colorama()
        profileController = LearnPercentController(baseContext)
        this.handleClick()
    }

    private fun handleClick(){
        this.binding.backbtn.setOnClickListener(this)
        this.binding.btnCheck.setOnClickListener(this)
    }

    private fun colorama(){
        val spannableString = SpannableString(text1)
        val spannableString2 = SpannableString(text2)


        for (word in pythonKeyWords) {
            val start = text1.indexOf(word)
            val end = start + word.length
            if (start != -1) {
                spannableString.setSpan(
                    ForegroundColorSpan(Color.BLUE),
                    start,
                    end,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }

        this.binding.text.text = spannableString

        for (word in pythonKeyWords) {
            val start = text2.indexOf(word)
            val end = start + word.length
            if (start != -1) {
                spannableString2.setSpan(
                    ForegroundColorSpan(Color.BLUE),
                    start,
                    end,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }

        this.binding.text2.text = spannableString2
    }

    override fun onClick(v: View) {
        when(v.id){
            binding.backbtn.id -> finish()
            binding.btnCheck.id -> profileController.save(LearnPercentEntity(v.id.toInt(), 20))
        }
    }
}