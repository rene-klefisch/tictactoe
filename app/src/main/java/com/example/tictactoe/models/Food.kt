package com.example.tictactoe.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Food")
data class Food(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "name")
    val name : String
)