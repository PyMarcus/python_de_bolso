package com.example.pythondebolso.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pythondebolso.models.UserEntity

@Dao
interface UserDAO {
    @Insert
    fun save(user: UserEntity)

    @Query("SELECT * FROM users WHERE email = :email")
    fun getUser(email: String): UserEntity?
}