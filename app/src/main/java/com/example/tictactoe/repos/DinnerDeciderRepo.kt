package com.example.tictactoe.repos

import androidx.lifecycle.LiveData
import com.example.tictactoe.app.AppExecutors
import com.example.tictactoe.db.daos.FoodDao
import com.example.tictactoe.models.Food
import java.util.*
import javax.inject.Inject

class DinnerDeciderRepo @Inject constructor(private val foodDao: FoodDao, private val appExecutors: AppExecutors){

    fun add(food : Food){
        appExecutors.diskIO().execute {
            foodDao.insert(food)
        }
    }

    fun randomFood() : LiveData<Food>{
        appExecutors.diskIO().execute {
            val foodList = foodDao.getFoodList()
            val random = Random()
            val randomFood = random.nextInt(foodList.count())
            return foodList[randomFood]
        }
    }
}