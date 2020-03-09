package com.example.tictactoe


import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    @Bindable
    val player1points = MutableLiveData<String>()

    @Bindable
    val player2points = MutableLiveData<String>()

}