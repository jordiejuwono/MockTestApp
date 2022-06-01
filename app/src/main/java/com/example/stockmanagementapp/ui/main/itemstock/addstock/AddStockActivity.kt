package com.example.stockmanagementapp.ui.main.itemstock.addstock

import android.content.Context
import android.content.Intent
import android.view.MenuItem
import android.widget.Toast
import com.example.stockmanagementapp.base.arch.BaseActivity
import com.example.stockmanagementapp.data.local.room.entity.Stock
import com.example.stockmanagementapp.databinding.ActivityAddStockBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class AddStockActivity :
    BaseActivity<ActivityAddStockBinding, AddStockViewModel>(ActivityAddStockBinding::inflate),
    AddStockContract.View {

    private var formMode = FORM_MODE_INPUT
    private var stock: Stock? = null

    override fun initView() {
        getIntentData()
        setBackButton()
        setFormData()
        saveDataToDatabase()
    }

    override fun getIntentData() {
        formMode = intent.getIntExtra(INTENT_FORM_MODE, FORM_MODE_INPUT)
        stock = intent.getParcelableExtra(STOCK_DATA)
    }

    override fun setFormData() {
        if (formMode == FORM_MODE_EDIT) {
            stock?.let {
                getViewBinding().etItemName.setText(it.itemName)
                getViewBinding().etQuantity.setText(it.stockQuantity)
                getViewBinding().etSupplier.setText(it.itemSupplier)
            }
        } else {
            getViewBinding().etItemName.setText("")
            getViewBinding().etQuantity.setText("")
            getViewBinding().etSupplier.setText("")
        }
    }

    override fun setBackButton() {
        supportActionBar?.title = "Manage Item Stock"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun saveDataToDatabase() {
        getViewBinding().btnConfirm.setOnClickListener {
            if (formMode == FORM_MODE_EDIT) {
                updateData()
                Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show()
            } else {
                insertData()
                Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
    }

    override fun insertData() {
        val itemName = getViewBinding().etItemName.text
        val itemQuantity = getViewBinding().etQuantity.text
        val itemSupplier = getViewBinding().etSupplier.text

        if (itemName!!.isNotEmpty() && itemQuantity.isNotEmpty() && itemSupplier.isNotEmpty()) {
            val stock = Stock(
                0,
                itemName.toString(),
                itemQuantity.toString(),
                itemSupplier.toString(),
                getCurrentDate()
            )
            getViewModel().insertStock(stock)
        } else {
            Toast.makeText(this, "Fill all the fields first!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun updateData() {
        val itemName = getViewBinding().etItemName.text
        val itemQuantity = getViewBinding().etQuantity.text
        val itemSupplier = getViewBinding().etSupplier.text

        if (itemName!!.isNotEmpty() && itemQuantity.isNotEmpty() && itemSupplier.isNotEmpty()) {
            stock = stock?.copy()?.apply {
                this.itemName = itemName.toString()
                this.itemSupplier = itemSupplier.toString()
                this.stockQuantity = itemQuantity.toString()
                this.lastUpdated = getCurrentDate()
            }

            stock?.let {
                getViewModel().updateStock(it)
            }
        } else {
            Toast.makeText(this, "Fill all the fields first!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.getDefault())
        val date = Date()

        return dateFormat.format(date)
    }

    companion object {
        const val FORM_MODE_INPUT = 0
        const val FORM_MODE_EDIT = 1
        const val INTENT_FORM_MODE = "intent_form_mode"
        const val STOCK_DATA = "stock_data"

        @JvmStatic
        fun startActivity(context: Context?, formMode: Int, stock: Stock? = null) {
            val intent = Intent(context, AddStockActivity::class.java)
            intent.putExtra(INTENT_FORM_MODE, formMode)
            stock?.let {
                intent.putExtra(STOCK_DATA, stock)
            }
            context?.startActivity(intent)
        }
    }

}