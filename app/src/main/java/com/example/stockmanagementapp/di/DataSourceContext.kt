package com.example.stockmanagementapp.di

import com.example.stockmanagementapp.data.local.room.dao.StockDao
import com.example.stockmanagementapp.data.local.room.datasource.StockDataSource
import com.example.stockmanagementapp.data.local.room.datasource.StockDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceContext {

    @Provides
    @Singleton
    fun provideStockDataSource(stockDao: StockDao): StockDataSource {
        return StockDataSourceImpl(stockDao)
    }

}