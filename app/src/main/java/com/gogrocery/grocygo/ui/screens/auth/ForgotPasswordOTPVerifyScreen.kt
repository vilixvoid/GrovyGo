package com.gogrocery.grocygo.ui.screens.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gogrocery.grocygo.ui.components.auth.ForgotPasswordOtpTopBar
import com.gogrocery.grocygo.ui.components.auth.NextButtonContainer
import com.gogrocery.grocygo.ui.components.auth.OTP_DIGITS
import com.gogrocery.grocygo.ui.components.auth.OtpTextField
import com.gogrocery.grocygo.ui.components.auth.ResendCodeTimer
import kotlinx.coroutines.delay

@Composable
fun ForgotPasswordOTPVerifyScreen(
    onBack: () -> Unit = {},
    onNext: () -> Unit = {},
    onResend: () -> Unit = {}
) {
    var otpValue by remember { mutableStateOf("") }
    var countdown by remember { mutableStateOf(56) }

    // Timer countdown
    LaunchedEffect(Unit) {
        while (countdown > 0) {
            delay(1000)
            countdown--
        }
    }

    Scaffold(
        topBar = {
            ForgotPasswordOtpTopBar(
                title = "Forgot password",
                onBackClick = onBack
            )
        },
        bottomBar = {
            NextButtonContainer(
                buttonText = "Next",
                isEnabled = otpValue.length == OTP_DIGITS,
                onNext = onNext
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Code has been sent to +6282*******39",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black.copy(alpha = 0.8f),
                modifier = Modifier.padding(bottom = 48.dp)
            )

            OtpTextField(
                otpText = otpValue,
                onOtpTextChange = { otpValue = it }
            )

            Spacer(modifier = Modifier.height(48.dp))

            ResendCodeTimer(
                countdown = countdown,
                onResend = {
                    if (countdown == 0) onResend()
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewForgotPasswordOTPVerifyScreen() {
    MaterialTheme {
        ForgotPasswordOTPVerifyScreen()
    }
}
