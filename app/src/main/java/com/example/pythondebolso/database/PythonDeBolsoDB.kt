package com.example.pythondebolso.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pythondebolso.models.LearnPercentEntity
import com.example.pythondebolso.models.UserEntity
import com.example.pythondebolso.repository.LearnPercentDAO
import com.example.pythondebolso.repository.UserDAO

@Database(entities = [UserEntity::class, LearnPercentEntity::class], version = 2, exportSchema = false)
abstract class PythonDeBolsoDB : RoomDatabase(){

    abstract fun userDAO(): UserDAO
    abstract fun percentDAO(): LearnPercentDAO


    companion object{
        private lateinit var INSTANCE: PythonDeBolsoDB

        fun getDatabase(context: Context): PythonDeBolsoDB{
            if(!::INSTANCE.isInitialized){
                synchronized(PythonDeBolsoDB::class){
                    INSTANCE = Room.databaseBuilder(
                        context,
                        PythonDeBolsoDB::class.java,
                        "pythondebolso_db"
                    ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }
}









































