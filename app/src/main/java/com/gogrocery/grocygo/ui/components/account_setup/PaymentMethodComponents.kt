package com.gogrocery.grocygo.ui.components.account_setup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

val VerdoGreen = Color(0xFF2FD080)

@Composable
fun PaymentScreenTopBar(onBack: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 24.dp, start = 24.dp, end = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(
            onClick = onBack,
            modifier = Modifier
                .size(36.dp)
                .background(VerdoGreen.copy(alpha = 0.1f), RoundedCornerShape(10.dp))
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Back",
                tint = VerdoGreen
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = "Payment method",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            color = Color.Black
        )
    }
}

@Composable
fun PaymentMethodCard(
    logoResId: Int,
    name: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val borderColor = if (isSelected) VerdoGreen else Color.LightGray
    val borderWidth = if (isSelected) 1.5.dp else 1.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .border(borderWidth, borderColor, RoundedCornerShape(12.dp))
            .background(Color.White, RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = logoResId),
            contentDescription = "$name Logo",
            contentScale = ContentScale.Fit
        )
    }
}

