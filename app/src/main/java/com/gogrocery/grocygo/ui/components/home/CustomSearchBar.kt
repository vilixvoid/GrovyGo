package com.gogrocery.grocygo.ui.components.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.gogrocery.grocygo.ui.theme.GrayIcon
import com.gogrocery.grocygo.ui.theme.LightVerdoGreen
import com.gogrocery.grocygo.ui.theme.VerdoGreen


@Composable
fun CustomSearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        placeholder = { Text("Search", color = GrayIcon) },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = GrayIcon) },
        trailingIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Tune, contentDescription = null, tint = VerdoGreen)
            }
        },
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            focusedContainerColor = LightVerdoGreen,
            unfocusedContainerColor = LightVerdoGreen
        )
    )
}
