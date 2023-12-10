package com.example.pythondebolso.controllers

import android.content.Context
import com.example.pythondebolso.database.PythonDeBolsoDB
import com.example.pythondebolso.models.UserEntity
import com.example.pythondebolso.repository.UserDAO
import org.mindrot.jbcrypt.BCrypt

class UserController(var context: Context) {

    private var userDAO: UserDAO = PythonDeBolsoDB.getDatabase(context).userDAO()

    fun save(user: UserEntity): Boolean{
        if (!user.email.contains("@") || user.password == "") {
            return false
        }
        try{
            userDAO.save(UserEntity(user.email, hashPassword(user.password)))
        }catch (e: Exception){
            return false
        }
        return true
    }

    // validate login
    fun getUser(email: String, password: String) : Boolean{
        val user: UserEntity? = userDAO.getUser(email)
        if(user?.password != null && user.password != ""){
            return checkPassword(password, user.password)
        }
        return false
    }

    private fun hashPassword(password: String) : String{
        val salt = BCrypt.gensalt()
        return BCrypt.hashpw(password, salt)
    }

    private fun checkPassword(candidate: String, hashedPassword: String): Boolean{
        return BCrypt.checkpw(candidate, hashedPassword)
    }
}