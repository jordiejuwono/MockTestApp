package com.example.stockmanagementapp.data.local.room.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "stock_table")
data class Stock(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "itemName")
    var itemName: String,
    @ColumnInfo(name = "stockQuantity")
    var stockQuantity: String,
    @ColumnInfo(name = "itemSupplier")
    var itemSupplier: String,
    @ColumnInfo(name = "lastUpdated")
    var lastUpdated: String
) : Parcelable