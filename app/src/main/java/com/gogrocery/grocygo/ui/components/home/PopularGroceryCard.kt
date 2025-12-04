package com.gogrocery.grocygo.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
import com.gogrocery.grocygo.data.model.PopularGroceryModel
import com.gogrocery.grocygo.ui.theme.GhostWhite
import com.gogrocery.grocygo.ui.theme.VerdoGreen

val popularGroceryList = listOf(
    PopularGroceryModel(R.drawable.cabbage_fresh, "Fresh Cabbage", "Lovy Grocery", 8),
    PopularGroceryModel(R.drawable.cucumber_fresh, "Fresh Cucumber", "Cloudy Grocery", 10),
    PopularGroceryModel(R.drawable.lettuce_fresh, "Fresh Lettuce", "Circlo Grocery", 6),
    PopularGroceryModel(R.drawable.cabbage_haty, "Fresh Cabbage", "Haty Grocery", 11),
    PopularGroceryModel(
        R.drawable.cabbage_green_fresh,
        "Fresh Green Cabbage",
        "Recto Grocery",
        13
    )
)

@Composable
fun PopularGroceryCard(
    modifier: Modifier = Modifier,
    imageResId: Int,
    productName: String,
    storeName: String,
    price: Int,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = productName,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(56.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(GhostWhite)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = productName,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                        color = Color.Black
                    )
                    Text(
                        text = storeName,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
            }

            Text(
                text = "$${price}",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                color = VerdoGreen, // ← pakai dari theme
                fontSize = 18.sp
            )
        }
    }
}
