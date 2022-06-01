package com.example.stockmanagementapp.ui.main.itemstock.stocklist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stockmanagementapp.R
import com.example.stockmanagementapp.data.local.room.entity.Stock
import com.example.stockmanagementapp.databinding.StockItemBinding

class StockListAdapter(private val editMode: EditMode) : RecyclerView.Adapter<StockListAdapter.StockListViewHolder>() {

    private val items: MutableList<Stock> = mutableListOf()

    interface EditMode {
        fun onClick(items: Stock)
    }

    class StockListViewHolder(val binding: StockItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockListViewHolder {
        return StockListViewHolder(
            StockItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StockListViewHolder, position: Int) {
        val currentPosition = items[position]
        holder.binding.tvItemName.text = currentPosition.itemName
        holder.binding.tvSupplier.text = currentPosition.itemSupplier
        holder.binding.tvLastUpdated.text = currentPosition.lastUpdated
        holder.binding.tvQuantity.text = holder.itemView.context.getString(
            R.string.quantity_format,
            currentPosition.stockQuantity.toString()
        )
        holder.itemView.setOnClickListener {
            editMode.onClick(currentPosition)
        }
    }

    override fun getItemCount(): Int = items.size

    private fun clearData() {
        this.items.clear()
    }

    fun setData(items: List<Stock>) {
        clearData()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}