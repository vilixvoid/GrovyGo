package com.gogrocery.grocygo.ui.screens.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gogrocery.grocygo.ui.components.auth.PasswordInputField
import com.gogrocery.grocygo.ui.components.auth.ResetPasswordTopBar
import com.gogrocery.grocygo.ui.components.auth.SaveButtonContainer
import com.gogrocery.grocygo.ui.theme.GrocyGoTheme
import com.gogrocery.grocygo.ui.theme.VerdoGreen

@Composable
fun ResetPasswordScreen(
    onBack: () -> Unit = {},
    onSave: () -> Unit = {}
) {
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(true) }
    var newVisible by remember { mutableStateOf(false) }
    var confirmVisible by remember { mutableStateOf(false) }

    val isFormValid = newPassword.isNotEmpty() &&
            confirmPassword.isNotEmpty() &&
            newPassword == confirmPassword

    Scaffold(
        topBar = {
            ResetPasswordTopBar(
                title = "Reset password",
                onBackClick = onBack
            )
        },
        bottomBar = {
            SaveButtonContainer(
                onSave = onSave,
                isEnabled = isFormValid
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
                text = "Create a new password",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black.copy(alpha = 0.8f),
                modifier = Modifier.padding(bottom = 32.dp)
            )

            PasswordInputField(
                value = newPassword,
                onValueChange = { newPassword = it },
                label = "New Password*",
                passwordVisible = newVisible,
                onToggleVisibility = { newVisible = !newVisible }
            )

            Spacer(modifier = Modifier.height(16.dp))

            PasswordInputField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = "Confirm New Password*",
                passwordVisible = confirmVisible,
                onToggleVisibility = { confirmVisible = !confirmVisible }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { rememberMe = it },
                    colors = CheckboxDefaults.colors(checkedColor = VerdoGreen)
                )
                Text("Remember me")
            }
        }
    }
}

@Preview(showSystemUi = true, name = "Reset Password Screen")
@Composable
fun PreviewResetPasswordScreen() {
    GrocyGoTheme {
        ResetPasswordScreen()
    }
}
