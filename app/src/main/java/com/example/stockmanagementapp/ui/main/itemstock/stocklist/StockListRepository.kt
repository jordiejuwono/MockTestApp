package com.example.stockmanagementapp.ui.main.itemstock.stocklist

import com.example.stockmanagementapp.base.arch.BaseRepositoryImpl
import com.example.stockmanagementapp.data.local.room.datasource.StockDataSource
import com.example.stockmanagementapp.data.local.room.entity.Stock
import javax.inject.Inject

class StockListRepository
@Inject constructor(private val stockDataSource: StockDataSource) : BaseRepositoryImpl(),
    StockListContract.Repository {
    override suspend fun getAllStock(): List<Stock> {
        return stockDataSource.getAllStock()
    }
}