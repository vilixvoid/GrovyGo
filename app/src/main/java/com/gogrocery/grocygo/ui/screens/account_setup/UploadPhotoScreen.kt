package com.gogrocery.grocygo.ui.screens.account_setup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gogrocery.grocygo.ui.components.account_setup.NextButtonContainer
import com.gogrocery.grocygo.ui.components.account_setup.PhotoOptionCard
import com.gogrocery.grocygo.ui.components.account_setup.UploadPhotoScreenTopBar

@Composable
fun UploadPhotoScreen(
    onBack: () -> Unit = {},
    onTakePhoto: () -> Unit = {},
    onPickGallery: () -> Unit = {},
    onNext: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            UploadPhotoScreenTopBar(
                onBack = onBack
            )
        },
        bottomBar = {
            NextButtonContainer(
                onNext = onNext
            )
        }
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
                modifier = Modifier.padding(bottom = 32.dp)
            )

            PhotoOptionCard(
                icon = Icons.Default.CameraAlt,
                text = "Take photo",
                onClick = onTakePhoto
            )

            Spacer(modifier = Modifier.height(24.dp))

            PhotoOptionCard(
                icon = Icons.Default.Folder,
                text = "From gallery",
                onClick = onPickGallery
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun UploadPhotoScreenPreview() {
    MaterialTheme {
        UploadPhotoScreen()
    }
}
