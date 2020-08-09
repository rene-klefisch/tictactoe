package com.example.tictactoe.modules

import android.app.Application
import androidx.room.Room
import com.example.tictactoe.db.daos.FoodDao
import com.example.tictactoe.db.FoodDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideFoodDb(app: Application) : FoodDb {
        return Room
            .databaseBuilder(app, FoodDb::class.java, "food.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideFoodDao(db: FoodDb) : FoodDao {
        return db.foodDao()
    }

}
