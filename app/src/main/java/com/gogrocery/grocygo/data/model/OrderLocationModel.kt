package com.gogrocery.grocygo.data.model

data class OrderLocationModel(
    val address: String = "",
    val latitude: Double? = null,
    val longitude: Double? = null
)
