package com.example.pythondebolso.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class UserEntity{

    constructor(email: String, password: String){
        this.email = email
        this.password = password
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "email")
    var email: String = String()

    @ColumnInfo(name = "password")
    var password: String = String()
}