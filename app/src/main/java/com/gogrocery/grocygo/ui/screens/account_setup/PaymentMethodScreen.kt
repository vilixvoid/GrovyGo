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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gogrocery.grocygo.R
import com.gogrocery.grocygo.ui.components.account_setup.NextButtonContainer
import com.gogrocery.grocygo.ui.components.account_setup.PaymentMethodCard
import com.gogrocery.grocygo.ui.components.account_setup.PaymentScreenTopBar

@Composable
fun PaymentMethodScreen(
    onBack: () -> Unit = {},
    onNext: () -> Unit = {}
) {
    var selectedMethod by remember { mutableStateOf("PayPal") }

    Scaffold(
        topBar = { PaymentScreenTopBar(onBack = onBack) },
        bottomBar = { NextButtonContainer(onNext = onNext) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
        ) {

            Text(
                text = "This data will be displayed in your account profile for security",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            PaymentMethodCard(
                logoResId = R.drawable.ic_paypal,
                name = "PayPal",
                isSelected = selectedMethod == "PayPal",
                onClick = { selectedMethod = "PayPal" }
            )
            Spacer(modifier = Modifier.height(16.dp))

            PaymentMethodCard(
                logoResId = R.drawable.ic_visa,
                name = "VISA",
                isSelected = selectedMethod == "VISA",
                onClick = { selectedMethod = "VISA" }
            )
            Spacer(modifier = Modifier.height(16.dp))

            PaymentMethodCard(
                logoResId = R.drawable.ic_payoneer,
                name = "Payoneer",
                isSelected = selectedMethod == "Payoneer",
                onClick = { selectedMethod = "Payoneer" }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PaymentMethodScreenPreview() {
    PaymentMethodScreen()
}

