package com.gogrocery.grocygo.data.model

data class CallModel(
    val callerName: String,
    val callStatus: String,
    val avatarResId: Int
)

data class RatingItem(
    val title: String,
    val rating: Float = 0f,
    val feedback: String = ""
)
