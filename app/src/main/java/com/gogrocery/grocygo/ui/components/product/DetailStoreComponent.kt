package com.gogrocery.grocygo.ui.components.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gogrocery.grocygo.R
import com.gogrocery.grocygo.data.model.Testimonial
import com.gogrocery.grocygo.ui.theme.LightVerdoGreen
import com.gogrocery.grocygo.ui.theme.VerdoGreen

@Composable
fun StoreHeaderImage(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.banner_store),
        contentDescription = "Store Header",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
    )
}

@Composable
fun StoreChip(label: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(LightVerdoGreen.copy(alpha = 0.4f))
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(label, color = VerdoGreen, fontSize = 12.sp, fontWeight = FontWeight.Medium)
    }
}

@Composable
fun StoreInfoRow(distance: String, rating: String) {
    Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                tint = VerdoGreen
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(distance, color = VerdoGreen, fontSize = 13.sp)
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                tint = VerdoGreen
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(rating, color = VerdoGreen, fontSize = 13.sp)
        }
    }
}

@Composable
fun StoreProductItem(name: String, price: String, imageRes: Int) {
    Card(
        modifier = Modifier
            .width(140.dp)
            .padding(end = 12.dp),
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()        // penting → supaya centering bekerja
                .padding(12.dp)
        ) {

            Image(
                painter = painterResource(id = imageRes),
                contentDescription = name,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                name,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                price,
                fontSize = 14.sp,
                color = VerdoGreen
            )
        }
    }
}

@Composable
fun TestimonialCard(item: Testimonial) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {

            // Avatar
            Image(
                painter = painterResource(id = item.avatarRes),
                contentDescription = item.name,
                modifier = Modifier
                    .size(55.dp)
                    .clip(RoundedCornerShape(50))
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {

                // Name + Rating Badge
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = item.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )

                    // Rating badge
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF4CAF50))
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "⭐ ${item.rating}",
                            fontSize = 13.sp,
                            color = Color.White
                        )
                    }
                }

                // Date
                Text(
                    text = item.date,
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Testimonial message
                Text(
                    text = item.comment,
                    fontSize = 14.sp
                )
            }
        }
    }
}
