package com.example.pythondebolso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.pythondebolso.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = ActivityMainMenuBinding.inflate(layoutInflater)

        setContentView(this.binding.root)

        this.handleEvents()
    }

    private fun handleEvents(){
        this.binding.about.setOnClickListener(this)
        this.binding.zen.setOnClickListener(this)
        this.binding.learn.setOnClickListener(this)
        this.binding.pratice.setOnClickListener(this)
    }

    override fun onClick(card: View) {
        when(card.id){
            this.binding.about.id -> this.about()
            this.binding.zen.id   -> this.zen()
            this.binding.learn.id -> this.learn()
            this.binding.pratice.id -> this.pratice()
        }
    }

    private fun about(){
        val aboutIntent = Intent(this, AboutActivity::class.java)
        startActivity(aboutIntent)
        overridePendingTransition(
            R.anim.fade_enter,
            R.anim.fate_exit
        )
    }

    private fun zen(){
        val zentIntent = Intent(this, ZenActivity::class.java)

        startActivity(zentIntent)
        overridePendingTransition(
            R.anim.fade_enter,
            R.anim.fate_exit
        )
    }

    private fun learn(){}

    private fun pratice(){}
}