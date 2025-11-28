package com.gogrocery.grocygo.ui.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gogrocery.grocygo.ui.theme.VerdoGreen


@Composable
fun HomeHeader(name: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(VerdoGreen),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Default.Face,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Hello, $name !",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )
        }

        Row {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(36.dp)
                    .background(VerdoGreen.copy(alpha = 0.1f), RoundedCornerShape(10.dp))
            ) {
                Icon(
                    Icons.Default.Notifications,
                    contentDescription = null,
                    tint = VerdoGreen
                )
            }

            Spacer(modifier = Modifier.width(17.dp))

            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(36.dp)
                    .background(VerdoGreen.copy(alpha = 0.1f), RoundedCornerShape(10.dp))
            ) {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = null,
                    tint = VerdoGreen)
            }
        }
    }
}
