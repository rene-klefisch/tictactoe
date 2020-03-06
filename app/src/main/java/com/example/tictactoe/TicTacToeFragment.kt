package com.example.tictactoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_tictactoe.*

var buttons : Array<Array<Button>>? = null
var player1turn = true
var roundCount = 0
var player1Points = 0
var player2Points = 0
var textViewPlayer1 : TextView? = null
var textViewPlayer2 : TextView? = null

class TicTacToeFragment : Fragment(), View.OnClickListener{

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tictactoe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttons = arrayOf(
            arrayOf(button_00, button_01, button_02),
            arrayOf(button_10, button_11, button_12),
            arrayOf(button_20, button_21, button_22))
        textViewPlayer1 = text_view_p1
        textViewPlayer2 = text_view_p2
        for (i in 0..2){
            for(j in 0..2){
                buttons!![i][j].setOnClickListener(this)
            }
        }
        val buttonReset = button_reset

        buttonReset.setOnClickListener {
            resetGame()
        }
    }

    override fun onClick(v: View?) {
        if((v as Button).text.toString() != ""){
            return
        }

        v.text = when(player1turn) {
            true -> "X"
            else -> "O"
        }

        roundCount++

        when(checkForWin()){
            true -> playerWins()
            else ->
                when(roundCount){
                    9 -> draw()
                    else -> player1turn = !player1turn
                }
        }
    }

    private fun checkForWin() : Boolean {

        for(i in 0..2){
            if(buttons!![i][0].text != ""
                && buttons!![i][0].text == buttons!![i][1].text
                && buttons!![i][0].text == buttons!![i][2].text
            ){
                return true
            } else if(buttons!![0][i].text != ""
                && buttons!![0][i].text == buttons!![1][i].text
                && buttons!![0][i].text == buttons!![2][i].text
            ) {
                return true
            }
        }

        if(buttons!![0][0].text != ""
            && buttons!![0][0].text == buttons!![1][1].text
            && buttons!![0][0].text == buttons!![2][2].text
        ){
            return true
        } else if(buttons!![0][2].text != ""
            && buttons!![0][2].text == buttons!![1][1].text
            && buttons!![0][2].text == buttons!![2][0].text
        ){
            return true
        }

        return false
    }

    private fun playerWins() {
        when(player1turn){
            true -> {
                player1Points++
            //    Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show()
            }
            else -> {
                player2Points++
          //      Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show()
            }
        }
        updatePointsText()
        resetBoard()
    }

    private fun draw() {
        //Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show()
        resetBoard()
    }

    private fun updatePointsText(){
        textViewPlayer1!!.text = "Player 1: $player1Points"
        textViewPlayer2!!.text = "Player 2: $player2Points"
    }

    private fun resetBoard(){
        for(i in 0..2){
            for (j in 0..2){
                buttons!![i][j].text = ""
            }
            roundCount = 0
            player1turn = true
        }
    }

    private fun resetGame(){
        player1Points = 0
        player2Points = 0
        updatePointsText()
        resetBoard()
    }
}