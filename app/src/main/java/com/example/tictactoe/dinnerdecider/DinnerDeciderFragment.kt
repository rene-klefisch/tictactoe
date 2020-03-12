package com.example.tictactoe.dinnerdecider

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.tictactoe.R
import kotlinx.android.synthetic.main.fragment_dinnerdecider.*

class DinnerDeciderFragment : Fragment() {

    lateinit var foodViewModel : DinnerDeciderViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dinnerdecider, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        foodViewModel = ViewModelProviders.of(this).get(DinnerDeciderViewModel::class.java)
        decideBtn.isVisible = false
        decideBtn.isClickable = false

        addFoodBtn.setOnClickListener {
            val newFood = addFoodTxt.text.toString()
            val added = foodViewModel.addFood(newFood)
            if (added) {
                addFoodTxt.text.clear()
                if(!decideBtn.isClickable) {
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
                selectedFoodTxt.text = foodViewModel.decide()
            }
        }
}