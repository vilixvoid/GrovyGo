package com.gogrocery.grocygo.ui.screens.account_setup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gogrocery.grocygo.R
import com.gogrocery.grocygo.ui.components.account_setup.AddressInputCard
import com.gogrocery.grocygo.ui.components.account_setup.LocationScreenTopBar
import com.gogrocery.grocygo.ui.components.account_setup.MapImageCard
import com.gogrocery.grocygo.ui.components.account_setup.SetLocationButtonContainer
import com.gogrocery.grocygo.ui.theme.GrocyGoTheme

@Composable
fun SetLocationMapScreen(
    onBack: () -> Unit = {},
    onSetLocation: () -> Unit = {},
    onEditAddress: () -> Unit = {}
) {
    Scaffold(
        topBar = { LocationScreenTopBar(title = "Set your location", onBack = onBack) },
        bottomBar = { SetLocationButtonContainer(onSetLocation = onSetLocation) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "This data will be displayed in your account profile for security",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .align(Alignment.Start)
            )

            MapImageCard(mapImageResId = R.drawable.ic_map_placeholder)

            Spacer(modifier = Modifier.height(24.dp))

            AddressInputCard(
                address = "Bung Tomo St. 109",
                onEditClick = onEditAddress
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SetLocationMapScreenPreview() {
    GrocyGoTheme {
        SetLocationMapScreen()
    }
}
