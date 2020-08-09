package com.example.tictactoe.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.tictactoe.viewmodels.DinnerDeciderViewModel
import com.example.tictactoe.util.Injectable
import com.example.tictactoe.R
import com.example.tictactoe.app.AppExecutors_Factory
import kotlinx.android.synthetic.main.fragment_dinnerdecider.*
import javax.inject.Inject

class DinnerDeciderFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val foodViewModel: DinnerDeciderViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dinnerdecider, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        decideBtn.isVisible = false
        decideBtn.isClickable = false

        addFoodBtn.setOnClickListener {
            val newFood = addFoodTxt.text.toString()
            //ToDo
            /*val added = foodViewModel.addFood(newFood)
            if (added) {
                addFoodTxt.text.clear()
                if(!decideBtn.isClickable) {
                    decideBtn.isVisible = true
                    decideBtn.isClickable = true
                    enableDecider()
                }
            } else {
                Toast.makeText(context, "Your Foodname can't consist of too many or only spaces!", Toast.LENGTH_LONG).show()
            }*/
        }
    }
        //ToDo
        /*fun enableDecider(){
            decideBtn.setOnClickListener {
                selectedFoodTxt.text = foodViewModel.decide()
            }
        }*/
}