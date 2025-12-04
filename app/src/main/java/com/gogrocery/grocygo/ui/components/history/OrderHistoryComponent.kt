package com.gogrocery.grocygo.ui.components.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gogrocery.grocygo.data.model.HistoryOrder
import com.gogrocery.grocygo.ui.theme.VerdoGreen

@Composable
fun StoreListItem(order: HistoryOrder) {

    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .shadow(
                elevation = 6.dp,
                shape = RoundedCornerShape(16.dp),
                clip = false
            )
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(12.dp)
            .fillMaxWidth()
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {

            Image(
                painter = painterResource(id = order.imageRes),
                contentDescription = order.name,
                modifier = Modifier
                    .size(58.dp)
                    .background(Color(0xFFF5F5F5), RoundedCornerShape(12.dp))
                    .padding(6.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(order.name, style = MaterialTheme.typography.titleMedium, color = Color.Black)
                Text(order.store, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                Text(order.price, style = MaterialTheme.typography.bodyMedium, color = VerdoGreen)
            }

            StatusBadge(order.status)
        }
    }
}

@Composable
fun StatusBadge(status: String) {

    val bgColor = when (status) {
        "Process" -> Color(0xFF4CAF50).copy(alpha = 0.2f)
        "Completed" -> Color(0xFF0A5DFE).copy(alpha = 0.2f)
        "Canceled" -> Color(0xFFFF0000).copy(alpha = 0.2f)
        else -> Color.LightGray
    }

    val textColor = when (status) {
        "Process" -> Color(0xFF4CAF50)
        "Completed" -> Color(0xFF0A5DFE)
        "Canceled" -> Color(0xFFFF0000)
        else -> Color.DarkGray
    }

    Box(
        modifier = Modifier
            .background(bgColor, RoundedCornerShape(12.dp))
            .padding(horizontal = 12.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            status,
            color = textColor,
            style = MaterialTheme.typography.bodySmall
        )
    }
}
