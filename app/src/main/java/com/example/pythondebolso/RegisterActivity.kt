package com.example.pythondebolso

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.Window
import android.widget.Button
import com.example.pythondebolso.controllers.UserController
import com.example.pythondebolso.databinding.ActivityRegisterBinding
import com.example.pythondebolso.models.UserEntity
import com.google.android.material.textview.MaterialTextView

class RegisterActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var userController: UserController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(this.binding.root)

        this.userController = UserController(baseContext)

        this.handleEvents()
    }

    private fun handleEvents(){
        this.binding.btnRegister.setOnClickListener(this)
        this.binding.registerLogin.setOnClickListener(this)
    }

    override fun onClick(click: View) {
        when(click.id){
            this.binding.btnRegister.id -> this.register()
            this.binding.registerLogin.id -> this.backToLogin()
        }
    }

    private fun register(){
        val email: String = this.binding.login.editText?.text.toString()
        val password: String = this.binding.password.editText?.text.toString()
        if(userController.save(UserEntity(email, password))){
            runOnUiThread{
                showDialog("Usuário cadastrado!")
            }
        }else{
            runOnUiThread {
                showDialog("Falha ao cadastrar usuário!")
            }
        }
    }

    private fun backToLogin(){
        val loginIntent: Intent = Intent(this, LoginActivity::class.java)
        startActivity(loginIntent)
        overridePendingTransition(
            R.anim.spin_enter,
            R.anim.spin_exit
        )
    }

    private fun showDialog(message: String) {
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
            if(message == "Usuário cadastrado!"){
                val loginIntent: Intent = Intent(this, LoginActivity::class.java)
                startActivity(loginIntent)
                overridePendingTransition(
                    R.anim.spin_enter,
                    R.anim.spin_exit
                )
            }
            dialog.dismiss()
        }

        btnNotOk.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}