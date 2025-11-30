package com.gogrocery.grocygo.data.model

data class ChatListModel(
    val name: String,
    val lastMessage: String,
    val time: String,
    val isUnread: Boolean = false,
    val avatarResId: Int
)
