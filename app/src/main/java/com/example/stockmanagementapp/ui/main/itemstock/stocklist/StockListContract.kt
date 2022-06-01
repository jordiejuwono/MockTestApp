package com.example.stockmanagementapp.ui.main.itemstock.stocklist

import androidx.lifecycle.LiveData
import com.example.stockmanagementapp.base.model.Resource
import com.example.stockmanagementapp.data.local.room.entity.Stock

interface StockListContract {
    interface View {
        fun getData()
        fun initList()
        fun addOrEditStock()
        fun setDataToRecyclerView(data: List<Stock>)
    }
    interface Repository {
        suspend fun getAllStock(): List<Stock>
    }
    interface ViewModel {
        fun getAllStock()
        fun getAllStockLiveData(): LiveData<Resource<List<Stock>>>
    }
}