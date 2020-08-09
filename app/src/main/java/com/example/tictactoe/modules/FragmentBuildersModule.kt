package com.example.tictactoe.modules

import com.example.tictactoe.fragments.DinnerDeciderFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeDinnerDeciderFragment(): DinnerDeciderFragment
}