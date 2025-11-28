package com.gogrocery.grocygo.ui.screens.users.product

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gogrocery.grocygo.ui.components.home.CustomSearchBar
import com.gogrocery.grocygo.ui.components.home.PopularGroceryCard
import com.gogrocery.grocygo.ui.components.home.popularGroceryList
import com.gogrocery.grocygo.ui.theme.VerdoGreen

@Composable
fun PopularGroceryScreen(
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = onBackClick,
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
                    text = "Popular Store",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    color = Color.Black
                )
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
                .background(Color(0xFFF0F4F8))
        ) {

            // 🔍 Search Bar
            CustomSearchBar()

            Spacer(modifier = Modifier.height(16.dp))

            // 🛒 Grid 2 kolom × 4 baris
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(popularGroceryList) { item ->
                    PopularGroceryCard(
                        imageResId = item.imageResId,
                        productName = item.productName,
                        storeName = item.storeName,
                        price = item.price
                    )
                }
            }

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewPopularGroceryScreen() {
    PopularGroceryScreen()
}
