package com.gogrocery.grocygo.ui.screens.users.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gogrocery.grocygo.ui.components.home.CustomSearchBar
import com.gogrocery.grocygo.ui.components.home.HomeHeader
import com.gogrocery.grocygo.ui.components.home.PopularGroceryCard
import com.gogrocery.grocygo.ui.components.home.PopularStoreCard
import com.gogrocery.grocygo.ui.components.home.SectionHeader
import com.gogrocery.grocygo.ui.components.home.SpecialPromoCard
import com.gogrocery.grocygo.ui.components.home.popularStoreList
import com.gogrocery.grocygo.ui.components.navigation.CustomBottomNavigationBar

@Composable
fun HomePageUserScreen() {
    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(bottom = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                CustomBottomNavigationBar()
            }
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
        ) {

            item {
                HomeHeader(name = "Daniel")
                Spacer(modifier = Modifier.height(24.dp))

                CustomSearchBar()
                Spacer(modifier = Modifier.height(24.dp))

                SpecialPromoCard()
                Spacer(modifier = Modifier.height(24.dp))

                // ==========================
                // POPULAR STORE (Horizontal)
                // ==========================
                SectionHeader(title = "Popular Store")

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(popularStoreList) { item ->
                        PopularStoreCard(
                            name = item.name,
                            time = item.time,
                            iconRes = item.iconRes
                        )
                    }
                }


                Spacer(modifier = Modifier.height(24.dp))

                // ==========================
                // POPULAR GROCERY (Vertical)
                // ==========================
                SectionHeader(title = "Popular Grocery")

                Spacer(modifier = Modifier.height(12.dp))
            }

            // Menampilkan item grocery secara vertical
            items(10) { index ->
                PopularGroceryCard(
                    imageResId = com.gogrocery.grocygo.R.drawable.image_grocery_placeholder,
                    productName = "Fresh Cabbage $index",
                    storeName = "Lovy Grocery",
                    price = "$8"
                )
                Spacer(modifier = Modifier.height(12.dp))
            }

            item { Spacer(modifier = Modifier.height(100.dp)) }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHomePageUserScreen() {
    MaterialTheme {
        HomePageUserScreen()
    }
}
