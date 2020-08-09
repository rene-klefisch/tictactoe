package com.example.tictactoe.fragments



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.tictactoe.R
import com.example.tictactoe.databinding.FragmentTictactoeBinding
import com.example.tictactoe.viewmodels.TicTacToeViewModel


class TicTacToeFragment : Fragment(){

    lateinit var viewModel: TicTacToeViewModel
    private lateinit var binding: FragmentTictactoeBinding
    private val gameListener = View.OnClickListener { view ->
        var row: Int = -1
        var column: Int = -1
        when(view.id) {
            R.id.button_00 -> {
                row = 0
                column = 0
            }
            R.id.button_01 -> {
                row = 0
                column = 1
            }
            R.id.button_02 -> {
                row = 0
                column = 2
            }
            R.id.button_10 -> {
                row = 1
                column = 0
            }
            R.id.button_11 -> {
                row = 1
                column = 1
            }
            R.id.button_12 -> {
                row = 1
                column = 2
            }
            R.id.button_20 -> {
                row = 2
                column = 0
            }
            R.id.button_21 -> {
                row = 2
                column = 1
            }
            R.id.button_22 -> {
                row = 2
                column = 2
            }
            R.id.button_reset -> {
                viewModel.startNewGame()
            }
        }
        if (row != -1 && column != -1) {
            viewModel.makeTurn(row, column)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_tictactoe, container, false)
        binding.clicker = gameListener
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TicTacToeViewModel::class.java)
        viewModel.getGame().observe(viewLifecycleOwner, Observer {
            binding.game = it
        })
    }


}