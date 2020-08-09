package com.example.tictactoe.models

enum class Player {
    PLAYER_1,
    PLAYER_2
}

enum class FieldState {
    EMPTY,
    X,
    O
}

class GameField {

    var field: Array<Array<FieldState>> = Array(3) {
        Array(3) {
            FieldState.EMPTY
        }
    }

    init {
        for (row in 0..2) {
            for (column in 0..2) {
                field[row][column] =
                    FieldState.EMPTY
            }
        }
    }

    fun get(row: Int, column: Int): String? {
        return when (field[row][column]) {
            FieldState.EMPTY -> null
            FieldState.X -> "X"
            FieldState.O -> "O"
        }
    }

    fun set(row: Int, column: Int, state: FieldState) {
        field[row][column] = state
    }

    fun hasMoreTurns() : Boolean {
        return field.any { row -> row.any { it == FieldState.EMPTY } }
    }

    fun clear() {
        for (row in 0..2) {
            for (column in 0..2) {
                field[row][column] =
                    FieldState.EMPTY
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameField

        if (!field.contentDeepEquals(other.field)) return false

        return true
    }

    override fun hashCode(): Int {
        return field.contentDeepHashCode()
    }
}


data class Game(
    var gameField: GameField,
    var turn: Player = Player.PLAYER_1,
    var player1Points : Int = 0,
    var player2Points : Int = 0
) {

    fun makeTurn(row : Int, column: Int) {
        when(gameField.get(row, column)) {
            null -> {
                val field = when (turn) {
                    Player.PLAYER_1 -> {
                        turn = Player.PLAYER_2
                        FieldState.X
                    }
                    Player.PLAYER_2 -> {
                        turn = Player.PLAYER_1
                        FieldState.O
                    }
                }
                gameField.set(row, column, field)
                if (checkForWin()) {
                    when (turn) {
                        Player.PLAYER_1 -> {
                            player2Points++
                        }
                        Player.PLAYER_2 -> {
                            player1Points++
                        }
                    }
                    gameField.clear()
                    turn = Player.PLAYER_1
                } else if(!gameField.hasMoreTurns()){
                    turn = Player.PLAYER_1
                    gameField.clear()
                }
            }
        }
    }

    private fun checkForWin() : Boolean {

        for(i in 0..2){
            if(gameField.get(i, 0) != null
                && gameField.get(i, 0) == gameField.get(i, 1)
                && gameField.get(i, 0) == gameField.get(i, 2)){
                return true
            } else if (gameField.get(0, i) != null
                && gameField.get(0, i) == gameField.get(1, i)
                && gameField.get(0, i) == gameField.get(2, i)) {
                return true
            }
        }

        if(gameField.get(0, 0) != null
            && gameField.get(0, 0) == gameField.get(1, 1)
            && gameField.get(0, 0) == gameField.get(2, 2)){
            return true
        } else if(gameField.get(0, 2) != null
            && gameField.get(0, 2) == gameField.get(1, 1)
            && gameField.get(0, 2) == gameField.get(2, 0)){
            return true
        }

        return false
    }

    fun getPlayer1PointsString() : String{
        return "Player 1: $player1Points"
    }

    fun getPlayer2PointsString() : String{
        return "Player 2: $player2Points"
    }
}