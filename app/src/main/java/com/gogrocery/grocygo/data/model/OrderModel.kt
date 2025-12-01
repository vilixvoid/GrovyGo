package com.gogrocery.grocygo.data.model

data class OrderItem(
    val productName: String,
    val storeName: String,
    val price: Int,
    val quantity: Int,
    val imageResId: Int
)
