package com.example.tictactoe.dinnerdecider

import androidx.lifecycle.ViewModel

class DinnerDeciderViewModel : ViewModel() {

    fun addFood(food: String) : Boolean {
        val charArray = food.toCharArray()
        if(food != "" && food != " " && validateNewFood(charArray)) {
            DinnerDeciderRepo.add(food)
            return true
        } else {
            return false
        }
    }

    fun validateNewFood(charArray : CharArray) : Boolean{
        var valid = true
        for (i in 1 until charArray.size) {
            if(charArray[i - 1] == ' ' && charArray[i] ==' ') {
                valid = false
            }
        }
        return valid
    }

    fun decide() : String{
        return DinnerDeciderRepo.randomFood()
    }

}