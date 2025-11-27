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
import com.gogrocery.grocygo.ui.components.account_setup.NextButtonContainer
import com.gogrocery.grocygo.ui.components.account_setup.ProfilePhotoArea
import com.gogrocery.grocygo.ui.components.account_setup.UploadPhotoScreenTopBar

@Composable
fun UploadPhotoScreenCompleted(
    onBack: () -> Unit = {},
    onEditPhoto: () -> Unit = {},
    onNext: () -> Unit = {}
) {
    Scaffold(
        topBar = { UploadPhotoScreenTopBar(title = "Upload your photo", onBack = onBack) },
        bottomBar = { NextButtonContainer(onNext = onNext) }
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
                    .padding(bottom = 48.dp)
                    .align(Alignment.Start)
            )

            ProfilePhotoArea(
                avatarResId = R.drawable.ic_profile,
                onEditClick = onEditPhoto
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun UploadPhotoScreenCompletedPreview() {
    MaterialTheme {
        UploadPhotoScreenCompleted()
    }
}
