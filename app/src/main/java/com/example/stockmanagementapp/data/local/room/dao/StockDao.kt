package com.example.stockmanagementapp.data.local.room.dao

import androidx.room.*
import com.example.stockmanagementapp.data.local.room.entity.Stock

@Dao
interface StockDao {
    @Query("SELECT * FROM stock_table")
    suspend fun getAllStock(): List<Stock>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStock(stock: Stock): Long

    @Update
    suspend fun updateStock(stock: Stock): Int

    @Delete
    suspend fun deleteStock(stock: Stock): Int
}