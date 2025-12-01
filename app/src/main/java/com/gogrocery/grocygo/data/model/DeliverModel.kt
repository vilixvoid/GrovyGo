package com.gogrocery.grocygo.data.model

data class AddressItem(
    val type: String,
    val address: String
)

val mockAddresses = listOf(
    AddressItem("Home", "Bung Tomo St. 109"),
    AddressItem("Office", "Mayjen Sungkono St. 55")
)
