package com.example.tictactoe.viewmodels

import androidx.lifecycle.ViewModel
import com.example.tictactoe.db.FoodDb
import com.example.tictactoe.models.Food
import com.example.tictactoe.repos.DinnerDeciderRepo
import javax.inject.Inject

class DinnerDeciderViewModel @Inject constructor(private val dinnerDeciderRepo: DinnerDeciderRepo) : ViewModel() {

    fun addFood(food: String) {
        val newFood = Food(food)
        dinnerDeciderRepo.add(newFood)
    }

 /*   fun decide() : String{
        return DinnerDeciderRepo.randomFood()
    }*/

}