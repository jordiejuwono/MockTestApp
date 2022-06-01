package com.example.stockmanagementapp.di

import android.content.Context
import androidx.room.Room
import com.example.stockmanagementapp.data.local.room.database.StockDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationContext {

    @Provides
    @Singleton
    fun provideStockDao(database: StockDatabase) =
        database.stockDao()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, StockDatabase::class.java, "stock_database").build()

}