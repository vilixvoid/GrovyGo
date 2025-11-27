package com.gogrocery.grocygo.ui.screens.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Sms
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
import com.gogrocery.grocygo.ui.components.auth.ContactOption
import com.gogrocery.grocygo.ui.components.auth.ContactOptionCard
import com.gogrocery.grocygo.ui.components.auth.ForgotPasswordTopBar
import com.gogrocery.grocygo.ui.components.auth.NextButtonContainer

@Composable
fun ForgotPasswordScreen(
    onBack: () -> Unit = {},
    onNext: () -> Unit = {}
) {
    var selectedOption by remember { mutableStateOf<ContactOption>(ContactOption.SMS) }

    Scaffold(
        topBar = { ForgotPasswordTopBar(title = "Forgot password?", onBack = onBack) },
        bottomBar = { NextButtonContainer("Next", onNext) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
        ) {
            Text(
                text = "Select which contact details should we use to reset your password",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black.copy(alpha = 0.8f),
                modifier = Modifier.padding(bottom = 32.dp)
            )

            ContactOptionCard(
                icon = androidx.compose.material.icons.Icons.Default.Sms,
                type = "via SMS:",
                detail = "+6282*******39",
                isSelected = selectedOption == ContactOption.SMS,
                onClick = { selectedOption = ContactOption.SMS }
            )

            Spacer(modifier = Modifier.height(24.dp))

            ContactOptionCard(
                icon = androidx.compose.material.icons.Icons.Default.Email,
                type = "via Email:",
                detail = "ex***le@yourdomain.com",
                isSelected = selectedOption == ContactOption.Email,
                onClick = { selectedOption = ContactOption.Email }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ForgotPasswordScreenPreview() {
    MaterialTheme {
        ForgotPasswordScreen()
    }
}
