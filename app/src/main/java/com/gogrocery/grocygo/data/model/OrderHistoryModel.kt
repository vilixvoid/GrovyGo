package com.gogrocery.grocygo.data.model

import com.gogrocery.grocygo.R

data class HistoryOrder(
    val imageRes: Int,
    val name: String,
    val store: String,
    val price: String,
    val status: String
)

val mockOrders = listOf(
    HistoryOrder(R.drawable.cabbage_fresh, "Fresh Cabbage", "Lovy Grocery", "$12", "Process"),
    HistoryOrder(R.drawable.cabbage_haty, "Fresh Lettuce", "Circlo Grocery", "$11", "Process"),
    HistoryOrder(R.drawable.cabbage_green_fresh, "Fresh Cabbage", "Recto Grocery", "$9", "Completed"),
    HistoryOrder(R.drawable.cabbage_green_fresh, "Fresh Cabbage", "Haty Grocery", "$10", "Canceled")
)
