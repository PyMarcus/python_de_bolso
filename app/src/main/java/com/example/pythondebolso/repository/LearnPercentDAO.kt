package com.example.pythondebolso.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pythondebolso.models.LearnPercentEntity

@Dao
interface LearnPercentDAO {
    @Insert
    fun save(learnPercent: LearnPercentEntity)

    @Query("SELECT sum(status) FROM learn_percent")
    fun getPercent(): Int
}