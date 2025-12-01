package com.gogrocery.grocygo.data.model

import com.gogrocery.grocygo.R

data class PaymentMethod(
    val name: String,
    val maskedNumber: String,
    val iconResId: Int
)

val mockPaymentMethods = listOf(
    PaymentMethod("PayPal", "+6282****39", R.drawable.ic_paypal),
    PaymentMethod("VISA", "3821****58", R.drawable.ic_visa),
    PaymentMethod("Payoneer", "4627****65", R.drawable.ic_payoneer)
)
