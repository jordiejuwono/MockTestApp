package com.example.stockmanagementapp.ui.main.itemstock.addstock

import androidx.lifecycle.LiveData
import com.example.stockmanagementapp.data.local.room.entity.Stock

interface AddStockContract {
    interface View {
        fun setBackButton()
        fun saveDataToDatabase()
        fun setFormData()
        fun getCurrentDate(): String
        fun getIntentData()
        fun updateData()
        fun insertData()
    }
    interface Repository {
        suspend fun insertStock(stock: Stock): Long
        suspend fun updateStock(stock: Stock): Int
        suspend fun deleteStock(stock: Stock): Int
    }
    interface ViewModel {
        fun insertStock(stock: Stock)
        fun updateStock(stock: Stock)
        fun deleteStock(stock: Stock)
    }
}