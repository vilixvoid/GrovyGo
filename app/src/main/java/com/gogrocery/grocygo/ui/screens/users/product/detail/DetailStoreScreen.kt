package com.gogrocery.grocygo.ui.screens.users.product.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gogrocery.grocygo.data.model.StoreDetail
import com.gogrocery.grocygo.data.model.mockStoreDetail
import com.gogrocery.grocygo.ui.components.product.StoreChip
import com.gogrocery.grocygo.ui.components.product.StoreHeaderImage
import com.gogrocery.grocygo.ui.components.product.StoreInfoRow
import com.gogrocery.grocygo.ui.components.product.StoreProductItem
import com.gogrocery.grocygo.ui.components.product.TestimonialCard
import com.gogrocery.grocygo.ui.theme.VerdoGreen

@Composable
fun DetailStoreScreen(store: StoreDetail) {

    val scrollState = rememberScrollableState { delta -> delta }

    Box(modifier = Modifier.fillMaxSize()) {

        StoreHeaderImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )

        // BOTTOM DETAIL PANEL (scrollable)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .align(Alignment.BottomCenter)
                .offset(y = 200.dp)
                .scrollable(
                    state = scrollState,
                    orientation = Orientation.Vertical
                )
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(Color.White)
                .padding(20.dp)
        ) {

            Column {

                StoreChip(label = "Popular")

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    store.name,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                StoreInfoRow(store.distance, store.rating)

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    store.description,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Popular Grocery",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "See all",
                        color = VerdoGreen,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                LazyRow {
                    items(store.groceries) { item ->
                        StoreProductItem(
                            name = item.name,
                            price = item.price,
                            imageRes = item.imageRes
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Testimonioals",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "See all",
                        color = VerdoGreen,
                        fontSize = 14.sp
                    )
                }
                LazyColumn {
                    items(store.testimonials) { item ->
                        TestimonialCard(item = item)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GroceryDetailScreenPreview() {
    DetailStoreScreen(store = mockStoreDetail())
}
