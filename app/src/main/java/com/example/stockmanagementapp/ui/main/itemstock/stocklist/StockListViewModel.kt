package com.example.stockmanagementapp.ui.main.itemstock.stocklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.stockmanagementapp.base.arch.BaseViewModelImpl
import com.example.stockmanagementapp.data.local.room.entity.Stock
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.stockmanagementapp.base.model.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

@HiltViewModel
class StockListViewModel
@Inject constructor(private val repository: StockListRepository) : BaseViewModelImpl(),
    StockListContract.ViewModel {

    private val getAllStockResponse = MutableLiveData<Resource<List<Stock>>>()
    override fun getAllStockLiveData(): LiveData<Resource<List<Stock>>> = getAllStockResponse

    override fun getAllStock() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getAllStock()
                viewModelScope.launch(Dispatchers.Main) {
                    getAllStockResponse.value = Resource.Success(response)
                }
            } catch (e: Exception) {
                viewModelScope.launch(Dispatchers.Main) {
                    getAllStockResponse.value = Resource.Error(e.message.orEmpty())
                }
            }
        }
    }

}