package com.example.pythondebolso.controllers

import android.content.Context
import com.example.pythondebolso.database.PythonDeBolsoDB
import com.example.pythondebolso.models.LearnPercentEntity
import com.example.pythondebolso.repository.LearnPercentDAO

class LearnPercentController(var context: Context) {
    private var percentDAO: LearnPercentDAO = PythonDeBolsoDB.getDatabase(context).percentDAO()

    fun save(percent: LearnPercentEntity?): Boolean{
        try{
            if(percent != null){
                percentDAO.save(percent)
                return true
            }
        }catch (e: Exception){
            return false
        }
        return false
    }

    fun getPercent() : Int{
        return percentDAO.getPercent()
    }
}