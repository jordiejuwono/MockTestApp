package com.example.stockmanagementapp.base.arch

import android.util.Log
import androidx.lifecycle.ViewModel

open class BaseViewModelImpl : BaseContract.ViewModel, ViewModel() {
    override fun logResponse(msg: String?) {
        Log.d(BaseViewModelImpl::class.java.simpleName, msg.orEmpty())
    }
}