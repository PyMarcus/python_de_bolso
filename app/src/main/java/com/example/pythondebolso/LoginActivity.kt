package com.example.pythondebolso

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.pythondebolso.controllers.UserController
import com.example.pythondebolso.databinding.ActivityLoginBinding
import com.example.pythondebolso.models.UserEntity
import com.google.android.material.textview.MaterialTextView

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var userController: UserController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.binding = ActivityLoginBinding.inflate(layoutInflater)
        this.userController = UserController(baseContext)

        setContentView(this.binding.root)

        this.handleEvents()
    }

    private fun handleEvents() {
        this.binding.btnLogin.setOnClickListener(this)
        this.binding.registerLogin.setOnClickListener(this)
    }

    override fun onClick(click: View) {
        when (click.id) {
            this.binding.btnLogin.id -> this.login()
            this.binding.registerLogin.id -> this.register()
        }
    }

    private fun login() {
        val email: String = this.binding.login.editText?.text.toString()
        val password: String = this.binding.password.editText?.text.toString()

        if (userController.getUser(email, password)) {
            println("TESTE LOGIN OK")
        } else {
            runOnUiThread {
                showDialog("Usuário não cadastrado!")
            }
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
            dialog.dismiss()
        }

        btnNotOk.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}
