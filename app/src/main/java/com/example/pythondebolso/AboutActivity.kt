package com.example.pythondebolso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.pythondebolso.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = ActivityAboutBinding.inflate(layoutInflater)

        setContentView(this.binding.root)

        this.handleEvents()
    }

    private fun handleEvents(){
        this.binding.backbtn?.setOnClickListener(this)
    }

    override fun onClick(btnBack: View) {
        when(btnBack.id){
            this.binding.backbtn?.id -> this.back()
        }
    }

    private fun back(){
        finish()
    }
}