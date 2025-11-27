package com.gogrocery.grocygo.ui.screens.account_setup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.gogrocery.grocygo.ui.components.account_setup.BioInputField
import com.gogrocery.grocygo.ui.components.account_setup.BioScreenTopBar
import com.gogrocery.grocygo.ui.components.account_setup.DateOfBirthField
import com.gogrocery.grocygo.ui.components.account_setup.GenderDropdown
import com.gogrocery.grocygo.ui.components.account_setup.NextButtonContainer

@Composable
fun FillBioScreen(
    onBack: () -> Unit,
    onNext: () -> Unit
) {
    var fullName by remember { mutableStateOf("Daniel Sebastian") }
    var nickName by remember { mutableStateOf("Daniel") }
    var phoneNumber by remember { mutableStateOf("+6282-4535-5639") }
    var selectedGender by remember { mutableStateOf("Male") }
    var dateOfBirth by remember { mutableStateOf("August 25, 1995") }
    var address by remember { mutableStateOf("Bung Tomo St. 109") }

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = { BioScreenTopBar(onBack = onBack) },
        bottomBar = { NextButtonContainer(onNext = onNext) }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(scrollState)
                .padding(horizontal = 24.dp)
        ) {

            Text(
                text = "This data will be displayed in your account profile for security",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            BioInputField(
                value = fullName,
                onValueChange = { fullName = it },
                label = "Full Name*",
                placeholder = "Enter your full name"
            )
            Spacer(modifier = Modifier.height(16.dp))

            BioInputField(
                value = nickName,
                onValueChange = { nickName = it },
                label = "Nick Name*",
                placeholder = "Enter your nickname"
            )
            Spacer(modifier = Modifier.height(16.dp))

            BioInputField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = "Phone Number*",
                placeholder = "Enter your phone number"
            )
            Spacer(modifier = Modifier.height(16.dp))

            GenderDropdown(
                label = "Gender*",
                selectedGender = selectedGender,
                onGenderSelected = { selectedGender = it }
            )
            Spacer(modifier = Modifier.height(16.dp))

            DateOfBirthField(
                date = dateOfBirth,
                label = "Date of Birth*",
                onDateClicked = { }
            )
            Spacer(modifier = Modifier.height(16.dp))

            BioInputField(
                value = address,
                onValueChange = { address = it },
                label = "Address*",
                placeholder = "Enter your full address"
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewFillBioScreen() {
    FillBioScreen(
        onBack = {},
        onNext = {}
    )
}
