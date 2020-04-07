package com.example.tictactoe.tictactoe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TicTacToeViewModel : ViewModel(){

    private val gameData = MutableLiveData<Game>()

    init {
        gameData.value = Game(gameField = GameField())
    }

    fun getGame() = gameData

    fun makeTurn(row: Int, column: Int) {
        val game = gameData.value
        game?.makeTurn(row, column)
        gameData.value = game
    }

    fun startNewGame() {
        gameData.value = Game(gameField = GameField())
    }

}