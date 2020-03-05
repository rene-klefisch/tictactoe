package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnClickListener {

    var buttons : Array<Array<Button>>? = null
    var player1turn = true
    var roundCount = 0
    var player1Points = 0
    var player2Points = 0
    var textViewPlayer1 : TextView? = null
    var textViewPlayer2 : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttons = arrayOf(
            arrayOf(button_00, button_01, button_02),
            arrayOf(button_10, button_11, button_12),
            arrayOf(button_20, button_21, button_22))
        textViewPlayer1 = findViewById(R.id.text_view_p1)
        textViewPlayer2 = findViewById(R.id.text_view_p2)
        for (i in 0..2){
            for(j in 0..2){
                buttons!![i][j].setOnClickListener(this)
            }
        }
        val buttonReset = findViewById<Button>(R.id.button_reset)
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
            if(!buttons!![i][0].equals("")
                && buttons!![i][0].equals(buttons!![i][1])
                && buttons!![i][0].equals(buttons!![i][2])){
                return true
            } else if(!buttons!![0][i].equals("")
                && buttons!![0][i].equals(buttons!![1][i])
                && buttons!![0][i].equals(buttons!![2][i])) {
                return true
            }
        }

        if(!buttons!![0][0].equals("")
            && buttons!![0][0].equals(buttons!![1][1])
            && buttons!![0][0].equals(buttons!![2][2])){
            return true
        } else if(!buttons!![0][2].equals("")
            && buttons!![0][2].equals(buttons!![1][1])
            && buttons!![0][2].equals(buttons!![2][0])){
            return true
        }

        return false
    }

    private fun playerWins() {
        when(player1turn){
            true -> {
                player1Points++
                Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show()
            }
            else -> {
                player2Points++
                Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show()
            }
        }
        updatePointsText()
        resetBoard()
    }

    private fun draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show()
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("roundCount", roundCount)
        outState.putInt("player1Points", player1Points)
        outState.putInt("player2Points", player2Points)
        outState.putBoolean("player1Turn", player1turn)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        roundCount = savedInstanceState.getInt("roundCount")
        player1Points = savedInstanceState.getInt("player1Points")
        player2Points = savedInstanceState.getInt("player2Points")
        player1turn = savedInstanceState.getBoolean("player1Turn")
    }
}
