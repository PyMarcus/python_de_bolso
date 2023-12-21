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
import com.example.pythondebolso.controllers.LearnPercentController
import com.example.pythondebolso.databinding.ActivityFunctionsBinding
import com.example.pythondebolso.databinding.ActivityStructuresBinding
import com.example.pythondebolso.models.LearnPercentEntity
import com.google.android.material.textview.MaterialTextView

class FunctionsActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityFunctionsBinding
    private lateinit var profileController: LearnPercentController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityFunctionsBinding.inflate(layoutInflater)
        profileController = LearnPercentController(this)
        setContentView(this.binding.root)

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