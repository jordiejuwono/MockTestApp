package com.example.stockmanagementapp.data.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.stockmanagementapp.data.local.room.dao.StockDao
import com.example.stockmanagementapp.data.local.room.entity.Stock

@Database(entities = [Stock::class], version = 1, exportSchema = false)
abstract class StockDatabase: RoomDatabase() {

    abstract fun stockDao(): StockDao

}