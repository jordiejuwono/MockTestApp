package com.example.stockmanagementapp.ui.main.itemstock.addstock

import androidx.lifecycle.viewModelScope
import com.example.stockmanagementapp.base.arch.BaseViewModelImpl
import com.example.stockmanagementapp.data.local.room.entity.Stock
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddStockViewModel
    @Inject constructor(private val addStockRepository: AddStockRepository): BaseViewModelImpl(), AddStockContract.ViewModel {

    override fun insertStock(stock: Stock) {
        viewModelScope.launch {
            addStockRepository.insertStock(stock)
        }
    }

    override fun updateStock(stock: Stock) {
        viewModelScope.launch {
            addStockRepository.updateStock(stock)
        }
    }

    override fun deleteStock(stock: Stock) {
        viewModelScope.launch {
            addStockRepository.deleteStock(stock)
        }
    }
}