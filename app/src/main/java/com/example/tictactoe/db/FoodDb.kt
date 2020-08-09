package com.example.tictactoe.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tictactoe.db.daos.FoodDao
import com.example.tictactoe.models.Food

@Database(entities = [Food::class], version = 1)
abstract class FoodDb  : RoomDatabase() {

    abstract fun foodDao(): FoodDao
}