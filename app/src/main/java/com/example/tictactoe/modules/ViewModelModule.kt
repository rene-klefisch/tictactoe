package com.example.tictactoe.modules

import dagger.Module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tictactoe.viewmodels.DinnerDeciderViewModel
import com.example.tictactoe.viewmodels.DinnerDeciderViewModelFactory
import com.example.tictactoe.viewmodels.ViewModelKey
import dagger.Binds
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(DinnerDeciderViewModel::class)
    abstract fun bindUserViewModel(dinnerDeciderViewModel: DinnerDeciderViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factoryDinnerDecider: DinnerDeciderViewModelFactory): ViewModelProvider.Factory
}