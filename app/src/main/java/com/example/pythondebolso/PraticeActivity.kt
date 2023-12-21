package com.example.pythondebolso

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.Window
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.pythondebolso.controllers.LearnPercentController
import com.example.pythondebolso.databinding.ActivityLoopsBinding
import com.example.pythondebolso.databinding.ActivityPraticeBinding
import com.example.pythondebolso.models.LearnPercentEntity
import com.example.pythondebolso.view_model.PraticeViewModel
import com.google.android.material.textview.MaterialTextView

class PraticeActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityPraticeBinding
    private lateinit var profileController: LearnPercentController
    private lateinit var viewModel: PraticeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityPraticeBinding.inflate(layoutInflater)
        profileController = LearnPercentController(this)
        setContentView(this.binding.root)

        viewModel = ViewModelProvider(this).get(PraticeViewModel::class.java)

        this.handleEvents()
    }

    private fun handleEvents(){
        this.binding.backbtn.setOnClickListener(this)
        this.binding.btnCheck.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            binding.backbtn.id -> finish()
            binding.btnCheck.id -> showDialog(v)
        }
    }

    private fun showDialog(v: View) {
        val message: String = "Enviar teste?"
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.notify)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val text: MaterialTextView = dialog.findViewById(R.id.message)
        text.text = message

        val a1 = this.binding.yes1.isChecked
        var a1_r = "Não"
        if(a1){
            a1_r = "Sim"
        }
        val a2 = this.binding.yes2.isChecked
        var a2_r = "Não"
        if(a2){
            a2_r = "Sim"
        }

        var answers = mapOf<String, String>("question1" to a1_r, "question2" to a2_r)

        val btnOk: Button = dialog.findViewById(R.id.notify_ok)
        val btnNotOk: Button = dialog.findViewById(R.id.notify_cancel)

        btnOk.setOnClickListener {
            viewModel.check(answers)
            updateCardViews()
            dialog.dismiss()
        }

        btnNotOk.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun updateCardViews() {
        val cardView1 = findViewById<CardView>(R.id.image_example1)
        val cardView2 = findViewById<CardView>(R.id.image_example2)

        // Verifica o estado da pergunta e atualiza as cores
        if (viewModel.getQuestionState("question1")) {
            cardView1.setCardBackgroundColor(ContextCompat.getColor(this, R.color.green))
        } else {
            cardView1.setCardBackgroundColor(ContextCompat.getColor(this, R.color.red))
        }

        if (viewModel.getQuestionState("question2")) {
            cardView2.setCardBackgroundColor(ContextCompat.getColor(this, R.color.green))
        } else {
            cardView2.setCardBackgroundColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}