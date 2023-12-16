package com.example.pythondebolso.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "learn_percent")
class LearnPercentEntity {

    constructor()

    constructor(session: Int, status: Int){
        this.session = session
        this.status = status
    }


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "session")
    var session: Int = 0

    @ColumnInfo(name = "status")
    var status: Int = 0
}