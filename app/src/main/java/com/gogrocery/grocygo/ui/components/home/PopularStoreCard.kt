package com.gogrocery.grocygo.ui.components.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gogrocery.grocygo.R
import com.gogrocery.grocygo.data.model.PopularStoreModel


// LIST masih boleh di UI (karena ini dummy sementara)
val popularStoreList = listOf(
    PopularStoreModel("Lovy Grocery", "10 mins", R.drawable.ic_lovy_grocery),
    PopularStoreModel("Hearthy Grocery", "12 mins", R.drawable.ic_hearthy_grocery),
    PopularStoreModel("Haty Grocery", "8 mins", R.drawable.ic_haty_grocery),
    PopularStoreModel("Cloudy Grocery", "15 mins", R.drawable.ic_cloudy_grocery),
    PopularStoreModel("Circlo Grocery", "9 mins", R.drawable.ic_circlo_grocery),
    PopularStoreModel("Recto Grocery", "14 mins", R.drawable.ic_recto_grocery)
)

@Composable
fun PopularStoreCard(
    name: String,
    time: String,
    iconRes: Int
) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(180.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(50.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = name,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = time,
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
    }
}
