package com.example.stockmanagementapp.di

import com.example.stockmanagementapp.ui.main.itemstock.addstock.AddStockRepository
import com.example.stockmanagementapp.ui.main.itemstock.addstock.AddStockViewModel
import com.example.stockmanagementapp.ui.main.itemstock.stocklist.StockListRepository
import com.example.stockmanagementapp.ui.main.itemstock.stocklist.StockListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object ViewModelContext {

    @Provides
    @ActivityScoped
    fun provideStockListViewModel(stockListRepository: StockListRepository) : StockListViewModel {
        return StockListViewModel(stockListRepository)
    }

    @Provides
    @ActivityScoped
    fun provideAddStockViewModel(addStockRepository: AddStockRepository) : AddStockViewModel {
        return AddStockViewModel(addStockRepository)
    }

}