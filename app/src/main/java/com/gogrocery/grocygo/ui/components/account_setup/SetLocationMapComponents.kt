package com.gogrocery.grocygo.ui.components.account_setup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.unit.sp
import com.gogrocery.grocygo.ui.theme.LightVerdoGreen
import com.gogrocery.grocygo.ui.theme.VerdoGreen

// -----------------------------
// TOP BAR
// -----------------------------

// -----------------------------
// MAP IMAGE CARD
// -----------------------------
@Composable
fun MapImageCard(
    mapImageResId: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(450.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = BorderStroke(2.dp, VerdoGreen)
    ) {
        Image(
            painter = painterResource(id = mapImageResId),
            contentDescription = "Map View",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}



// -----------------------------
// ADDRESS CARD
// -----------------------------
@Composable
fun AddressInputCard(
    address: String,
    onEditClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clickable(onClick = onEditClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = LightVerdoGreen),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = BorderStroke(2.dp, VerdoGreen)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location Pin",
                    tint = VerdoGreen,
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        "Location",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                    Text(
                        address,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                }
            }

            IconButton(onClick = onEditClick) {
                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = "Edit Address",
                    tint = VerdoGreen
                )
            }
        }
    }
}

// -----------------------------
// BOTTOM BUTTON
// -----------------------------
@Composable
fun SetLocationButtonContainer(
    onSetLocation: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .padding(vertical = 24.dp)
    ) {
        Button(
            onClick = onSetLocation,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = VerdoGreen)
        ) {
            Text(
                "Set location",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                fontSize = 18.sp
            )
        }
    }
}
