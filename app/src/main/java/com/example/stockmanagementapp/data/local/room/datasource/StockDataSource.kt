package com.example.stockmanagementapp.data.local.room.datasource

import androidx.lifecycle.LiveData
import com.example.stockmanagementapp.data.local.room.entity.Stock

interface StockDataSource {
    //stock list
    suspend fun getAllStock(): List<Stock>
    suspend fun insertStock(stock: Stock): Long
    suspend fun updateStock(stock: Stock): Int
    suspend fun deleteStock(stock: Stock): Int
}