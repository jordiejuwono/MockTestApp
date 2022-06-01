package com.example.stockmanagementapp.data.local.room.datasource

import androidx.lifecycle.LiveData
import com.example.stockmanagementapp.data.local.room.dao.StockDao
import com.example.stockmanagementapp.data.local.room.entity.Stock
import javax.inject.Inject

class StockDataSourceImpl
@Inject constructor(private val stockDao: StockDao) :
    StockDataSource {
    //stock list
    override suspend fun getAllStock(): List<Stock> {
        return stockDao.getAllStock()
    }

    override suspend fun insertStock(stock: Stock): Long {
        return stockDao.insertStock(stock)
    }

    override suspend fun updateStock(stock: Stock): Int {
        return stockDao.updateStock(stock)
    }

    override suspend fun deleteStock(stock: Stock): Int {
        return stockDao.deleteStock(stock)
    }
}