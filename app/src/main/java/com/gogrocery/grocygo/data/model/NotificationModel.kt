package com.gogrocery.grocygo.data.model

enum class NotificationType {
    ORDER_SUCCESS,
    POINTS_RECEIVED
}

data class NotificationItem(
    val type: NotificationType,
    val title: String,
    val time: String
)

val mockNotifications = listOf(
    NotificationItem(NotificationType.ORDER_SUCCESS, "Your order is completed!", "20.00"),
    NotificationItem(NotificationType.ORDER_SUCCESS, "Your order is completed!", "16.00"),
    NotificationItem(NotificationType.POINTS_RECEIVED, "You received 200 points", "14.00"),
    NotificationItem(NotificationType.ORDER_SUCCESS, "Your order is completed!", "10.00")
)

