package com.example.tictactoe

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_dinnerdecider.*
import java.util.*

class DinnerDeciderFragment : Fragment() {

    private var foodList = arrayListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dinnerdecider, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(foodList.isEmpty()){
            decideBtn.isVisible = false
            decideBtn.isClickable = false
        }

        addFoodBtn.setOnClickListener {
            val newFood = addFoodTxt.text.toString()
            val charArray = newFood.toCharArray()
            if(newFood != "" && newFood != " " && validateNewFood(charArray)) {
                foodList.add(newFood)
                addFoodTxt.text.clear()
                println(foodList)
                if (!decideBtn.isClickable) {
                    decideBtn.isVisible = true
                    decideBtn.isClickable = true
                    enableDecider()
                }
            } else {
                Toast.makeText(context, "Your Foodname can't consist of too many or only spaces!", Toast.LENGTH_LONG).show()
            }
        }
    }

        fun enableDecider(){
            decideBtn.setOnClickListener {
                val random = Random()
                val randomFood = random.nextInt(foodList.count())
                selectedFoodTxt.text = foodList[randomFood]
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
}