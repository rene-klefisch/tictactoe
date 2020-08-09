package com.example.tictactoe.components

import com.example.tictactoe.app.TicTacToeApp
import com.example.tictactoe.modules.TicTacToeActivityModule
import com.example.tictactoe.modules.AppModule
import com.example.tictactoe.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        TicTacToeActivityModule::class,
        ViewModelModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(ticTacToeApp: TicTacToeApp): Builder

        fun build(): AppComponent
    }

    fun inject(ticTacToeApp : TicTacToeApp)
}