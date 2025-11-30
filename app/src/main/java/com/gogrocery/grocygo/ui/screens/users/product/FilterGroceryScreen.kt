package com.gogrocery.grocygo.ui.screens.users.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gogrocery.grocygo.ui.components.home.CustomSearchBar
import com.gogrocery.grocygo.ui.components.product.ChipItem
import com.gogrocery.grocygo.ui.components.product.FilterSection
import com.gogrocery.grocygo.ui.theme.VerdoGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterGroceryScreen(
    onBackClick: () -> Unit = {},
    onSearchClick: () -> Unit = {}
) {
    var selectedType by remember { mutableStateOf("Store") }
    var selectedLocation by remember { mutableStateOf("< 5 km") }
    val groceryOptions = listOf(
        "Artichoke", "Broccoli", "Cabbage", "Asparagus",
        "Celery", "Bean", "Corn", "Cucumber", "Lettuce"
    )
    val selectedGroceries = remember { mutableStateListOf("Cabbage", "Lettuce") }

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
                    text = "Find your grocery",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    color = Color.Black
                )
            }
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = onSearchClick,
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = VerdoGreen),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(
                        "Search",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
                .background(Color.Transparent)
                .verticalScroll(rememberScrollState())
        ) {

            // SEARCH BAR
            CustomSearchBar()
            Spacer(modifier = Modifier.height(10.dp))

            // TYPE
            FilterSection("Type") {
                FlowRow(
                    modifier = Modifier
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    listOf("Store", "Grocery").forEach { type ->
                        ChipItem(
                            text = type,
                            isSelected = selectedType == type,
                            onClick = { selectedType = type }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            // LOCATION
            FilterSection("Location") {
                FlowRow(
                    modifier = Modifier
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    listOf("1 km", "< 5 km", "< 10 km", "> 10 km").forEach { location ->
                        ChipItem(
                            text = location,
                            isSelected = selectedLocation == location,
                            onClick = { selectedLocation = location }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            // GROCERY
            FilterSection("Grocery") {
                FlowRow(
                    modifier = Modifier
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    groceryOptions.forEach { item ->
                        ChipItem(
                            text = item,
                            isSelected = selectedGroceries.contains(item),
                            onClick = {
                                if (selectedGroceries.contains(item))
                                    selectedGroceries.remove(item)
                                else selectedGroceries.add(item)
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewFilterGroceryScreen() {
    FilterGroceryScreen()
}
