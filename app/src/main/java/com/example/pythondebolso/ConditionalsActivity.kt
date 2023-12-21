package com.example.pythondebolso

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.View.OnClickListener
import android.view.Window
import android.widget.Button
import com.example.pythondebolso.controllers.LearnPercentController
import com.example.pythondebolso.databinding.ActivityConditionalsBinding
import com.example.pythondebolso.models.LearnPercentEntity
import com.google.android.material.textview.MaterialTextView

class ConditionalsActivity : AppCompatActivity(), OnClickListener {

    private lateinit var profileController: LearnPercentController
    private lateinit var binding: ActivityConditionalsBinding
    private val pythonKeyWords = listOf(
        "False", "None", "True", "and", "assert", "async", "await", "break",
        "class", "continue", "def", "del", "elif", "else", "except", "finally",
        "from", "global", "if", "import", "lambda", "nonlocal", "not",
        "pass", "raise", "return", "try", "while", "with", "yield", "Input", "Print"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = ActivityConditionalsBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
        profileController = LearnPercentController(baseContext)
        this.handleEvents()
        this.colorama()
    }

    private fun handleEvents(){
        this.binding.btnCheck.setOnClickListener(this)
        this.binding.backbtn.setOnClickListener{
            finish()
        }
    }

    private fun colorama(){
        val spannableString = SpannableString(this.binding
            .text.text)


        for (word in pythonKeyWords) {
            val start = this.binding.text.text.indexOf(word)
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

    }

    override fun onClick(v: View) {
        when(v.id) {
            binding.backbtn.id -> finish()
            binding.btnCheck.id -> showDialog(v)
        }
    }

    private fun showDialog(v: View) {
        val message: String = "Registrar sessão?"
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.notify)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val text: MaterialTextView = dialog.findViewById(R.id.message)
        text.text = message

        val btnOk: Button = dialog.findViewById(R.id.notify_ok)
        val btnNotOk: Button = dialog.findViewById(R.id.notify_cancel)

        btnOk.setOnClickListener {
            profileController.save(LearnPercentEntity(v.id.toInt(), 20))
            dialog.dismiss()
        }

        btnNotOk.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}