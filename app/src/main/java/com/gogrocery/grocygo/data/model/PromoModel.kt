package com.gogrocery.grocygo.data.model
import com.gogrocery.grocygo.R
data class PromoItem(
    val title: String,
    val imageResId: Int,
    val dealText: String = "Special Deal for December"
)
val mockPromos = listOf(
    PromoItem("Green Lettuce", R.drawable.cabbage_fresh),
    PromoItem("Ornamental Cabbage", R.drawable.cabbage_green_fresh),
    PromoItem("Dark Green Lettuce", R.drawable.cabbage_haty)
)
