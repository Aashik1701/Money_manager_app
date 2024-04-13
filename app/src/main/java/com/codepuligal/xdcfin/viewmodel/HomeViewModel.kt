package com.codepuligal.xdcfin.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codepuligal.xdcfin.R
import com.codepuligal.xdcfin.Utils
import com.codepuligal.xdcfin.data.ExpenseDatabase
import com.codepuligal.xdcfin.data.dao.ExpenseDao
import com.codepuligal.xdcfin.data.model.ExpenseEntity
import java.lang.IllegalArgumentException

class HomeViewModel(val dao: ExpenseDao) : ViewModel() {
    val expenses = dao.getAllExpense()

    fun getBalance(list: List<ExpenseEntity>): String {
        var balance = 0.0
        for (expense in list) {
            if (expense.type == "Income") {
                balance += expense.amount
            } else {
                balance -= expense.amount
            }
        }
        return "$ ${Utils.formatToDecimalValue(balance)}"
    }

    fun getTotalExpense(list: List<ExpenseEntity>): String {
        var total = 0.0
        for (expense in list) {
            total += expense.amount
        }

        return "$ ${Utils.formatToDecimalValue(total)}"
    }

    fun getTotalIncome(list: List<ExpenseEntity>): String {
        var totalIncome = 0.0
        for (expense in list) {
            if (expense.type == "Income") {
                totalIncome += expense.amount
            }
        }
        return "$ ${Utils.formatToDecimalValue(totalIncome)}"
    }

    fun getItemIcon(item: ExpenseEntity): Int {
        return if (item.category == "Paypal") {
            R.drawable.ic_paypal
        } else if (item.category == "Netflix") {
            R.drawable.ic_netflix
        } else if (item.category == "Starbucks") {
            R.drawable.ic_starbucks
        } else {
            R.drawable.ic_upwork
        }
    }
}

class HomeViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val dao = ExpenseDatabase.getInstance(context).expenseDao()
            return HomeViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}