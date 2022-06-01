package com.example.stockmanagementapp.ui.main.itemstock.addstock

import androidx.lifecycle.LiveData
import com.example.stockmanagementapp.base.arch.BaseRepositoryImpl
import com.example.stockmanagementapp.data.local.room.datasource.StockDataSource
import com.example.stockmanagementapp.data.local.room.entity.Stock
import javax.inject.Inject

class AddStockRepository
    @Inject constructor(private val stockDataSource: StockDataSource): BaseRepositoryImpl(), AddStockContract.Repository {
    override suspend fun insertStock(stock: Stock): Long {
        return stockDataSource.insertStock(stock)
    }

    override suspend fun updateStock(stock: Stock): Int {
        return stockDataSource.updateStock(stock)
    }

    override suspend fun deleteStock(stock: Stock): Int {
        return stockDataSource.deleteStock(stock)
    }

}