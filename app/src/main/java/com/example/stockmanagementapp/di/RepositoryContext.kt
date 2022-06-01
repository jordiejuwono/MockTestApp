package com.example.stockmanagementapp.di

import com.example.stockmanagementapp.data.local.room.datasource.StockDataSource
import com.example.stockmanagementapp.ui.main.itemstock.addstock.AddStockRepository
import com.example.stockmanagementapp.ui.main.itemstock.stocklist.StockListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryContext {

    @Provides
    @Singleton
    fun provideStockListRepository(stockDataSource: StockDataSource): StockListRepository {
        return StockListRepository(stockDataSource)
    }

    @Provides
    @Singleton
    fun provideAddStockRepository(stockDataSource: StockDataSource): AddStockRepository {
        return AddStockRepository(stockDataSource)
    }

}