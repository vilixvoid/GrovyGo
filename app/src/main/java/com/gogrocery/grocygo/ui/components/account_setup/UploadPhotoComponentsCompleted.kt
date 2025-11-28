package com.gogrocery.grocygo.ui.components.account_setup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

// pakai warna dari theme
private val GreenPrimary @Composable get() = MaterialTheme.colorScheme.primary


// ----------------------------------------------
// TOP BAR
// ----------------------------------------------
@Composable
fun UploadPhotoScreenTopBar(
    title: String,
    onBack: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onBack,
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
            text = title,
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            color = Color.Black
        )
    }
}


// ----------------------------------------------
// PROFILE PHOTO + EDIT BUTTON
// ----------------------------------------------
@Composable
fun ProfilePhotoArea(
    avatarResId: Int,
    onEditClick: () -> Unit
) {
    Box(
        modifier = Modifier.size(200.dp)
    ) {
        Image(
            painter = painterResource(id = avatarResId),
            contentDescription = "Profile Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .background(GreenPrimary.copy(alpha = 0.2f))
        )

        FloatingActionButton(
            onClick = onEditClick,
            modifier = Modifier
                .size(40.dp)
                .align(Alignment.BottomEnd)
                .offset(x = 5.dp, y = 5.dp),
            containerColor = VerdoGreen,
            shape = CircleShape
        ) {
            Icon(
                imageVector = Icons.Default.Create,
                contentDescription = "Edit Photo",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

