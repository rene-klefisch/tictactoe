package com.example.tictactoe.modules

import com.example.tictactoe.TicTacToeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class TicTacToeActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeTicTacToeActivity(): TicTacToeActivity
}