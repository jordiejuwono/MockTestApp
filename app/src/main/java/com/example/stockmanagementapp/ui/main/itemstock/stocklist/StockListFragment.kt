package com.example.stockmanagementapp.ui.main.itemstock.stocklist

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stockmanagementapp.base.arch.BaseFragment
import com.example.stockmanagementapp.base.model.Resource
import com.example.stockmanagementapp.data.local.room.entity.Stock
import com.example.stockmanagementapp.databinding.FragmentStockListBinding
import com.example.stockmanagementapp.ui.main.itemstock.addstock.AddStockActivity
import com.example.stockmanagementapp.ui.main.itemstock.stocklist.adapter.StockListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StockListFragment :
    BaseFragment<FragmentStockListBinding, StockListViewModel>(FragmentStockListBinding::inflate),
    StockListContract.View {

    private lateinit var adapter: StockListAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun initView() {
        addOrEditStock()
        getData()
        initList()
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    override fun getData() {
        getViewModel().getAllStock()
    }

    override fun initList() {
        adapter = StockListAdapter(object : StockListAdapter.EditMode {
            override fun onClick(items: Stock) {
                AddStockActivity.startActivity(requireContext(), AddStockActivity.FORM_MODE_EDIT, items)
            }

        })
        layoutManager = LinearLayoutManager(requireContext())
        getViewBinding().rvStockList.apply {
            adapter = this@StockListFragment.adapter
            layoutManager = this@StockListFragment.layoutManager
        }
    }

    override fun setDataToRecyclerView(data: List<Stock>) {
        data.let {
            adapter.setData(data)
        }
    }

    override fun addOrEditStock() {
        getViewBinding().fabAddStock.setOnClickListener {
            val intent = Intent(requireContext(), AddStockActivity::class.java)
            startActivity(intent)
        }
    }

    override fun observeData() {
        getViewModel().getAllStockLiveData().observe(this) {
            when (it) {
                is Resource.Loading -> {
                    showLoading(true)
                    showContent(false)
                    showError(false)
                }
                is Resource.Success -> {
                    showLoading(false)
                    showContent(true)
                    showError(false)
                    it.data.let { response ->
                        if (response != null) {
                            setDataToRecyclerView(response)
                        }
                    }
                }
                is Resource.Error -> {
                    showLoading(false)
                    showContent(false)
                    showError(true, it.message)
                }
            }
        }
    }

}