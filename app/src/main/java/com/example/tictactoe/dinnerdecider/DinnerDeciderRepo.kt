package com.example.tictactoe.dinnerdecider

import java.util.*

object DinnerDeciderRepo {

    private var foodList = arrayListOf<String>()

    fun add(food : String){
        foodList.add(food)
    }

    fun randomFood() : String{
        val random = Random()
        val randomFood = random.nextInt(foodList.count())
        return foodList[randomFood]
    }
}