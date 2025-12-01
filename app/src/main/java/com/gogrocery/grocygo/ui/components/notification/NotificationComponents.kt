package com.gogrocery.grocygo.ui.components.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gogrocery.grocygo.data.model.NotificationItem
import com.gogrocery.grocygo.data.model.NotificationType
import com.gogrocery.grocygo.ui.theme.PointYellow
import com.gogrocery.grocygo.ui.theme.VerdoGreen

@Composable
fun NotificationCardComponent(item: NotificationItem) {

    val iconColor = when (item.type) {
        NotificationType.ORDER_SUCCESS -> VerdoGreen
        NotificationType.POINTS_RECEIVED -> PointYellow
    }

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(iconColor)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                when (item.type) {
                    NotificationType.ORDER_SUCCESS ->
                        Icon(Icons.Default.Check, contentDescription = null, tint = Color.White)

                    NotificationType.POINTS_RECEIVED ->
                        Text("$", color = Color.White, fontSize = 18.sp)
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(Modifier.weight(1f)) {
                Text(item.title, fontSize = 16.sp)
                Text(item.time, fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationCardPreview() {
    NotificationCardComponent(
        item = NotificationItem(
            type = NotificationType.ORDER_SUCCESS,
            title = "Your order is completed!",
            time = "14.00"
        )
    )
}
