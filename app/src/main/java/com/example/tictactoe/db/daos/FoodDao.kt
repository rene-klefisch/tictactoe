package com.example.tictactoe.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tictactoe.models.Food

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(food: Food)

    @Query("SELECT COUNT(*) FROM Food")
    fun getFoodListSize() : Int

    @Query("SELECT * FROM Food WHERE name = :name")
    fun getFoodByName(name : String) : Food

    @Query("SELECT * FROM Food")
    fun getFoodList(): List<Food>

}