package com.gogrocery.grocygo.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gogrocery.grocygo.ui.theme.VerdoGreen

@Composable
fun SuccessResetPasswordScreen(
    onGoToLogin: () -> Unit = {}
) {
    Scaffold(
        bottomBar = { GoToLoginButtonContainer(onGoToLogin) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SuccessIconArea()

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Password Reset!",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                color = VerdoGreen
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Your password has been successfully updated.",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black.copy(alpha = 0.7f),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}

@Composable
fun SuccessIconArea() {
    Box(
        modifier = Modifier.wrapContentSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(180.dp)
                .background(Color.Transparent)
        )

        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(VerdoGreen),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Success",
                tint = Color.White,
                modifier = Modifier.size(70.dp)
            )
        }
    }
}

@Composable
fun GoToLoginButtonContainer(
    onGoToLogin: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .padding(vertical = 24.dp)
    ) {
        Button(
            onClick = onGoToLogin,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = VerdoGreen)
        ) {
            Text(
                "Go to Login",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SuccessResetPasswordScreenPreview() {
    MaterialTheme {
        SuccessResetPasswordScreen()
    }
}
