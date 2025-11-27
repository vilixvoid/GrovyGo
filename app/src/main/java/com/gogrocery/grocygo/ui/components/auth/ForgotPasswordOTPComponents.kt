package com.gogrocery.grocygo.ui.components.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gogrocery.grocygo.ui.theme.VerdoGreen

// 🔢 jumlah digit OTP
const val OTP_DIGITS = 4

@Composable
fun ForgotPasswordOtpTopBar(
    title: String,
    onBackClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { onBackClick() },
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

@Composable
fun OtpTextField(
    otpText: String,
    onOtpTextChange: (String) -> Unit
) {
    BasicTextField(
        value = TextFieldValue(text = otpText, selection = TextRange(otpText.length)),
        onValueChange = {
            if (it.text.all { char -> char.isDigit() }) {
                onOtpTextChange(it.text.take(OTP_DIGITS))
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        decorationBox = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                repeat(OTP_DIGITS) { index ->
                    OtpSingleBox(
                        digit = otpText.getOrNull(index)?.toString() ?: "",
                        isFocused = otpText.length == index
                    )
                }
            }
        }
    )
}

@Composable
fun OtpSingleBox(
    digit: String,
    isFocused: Boolean
) {
    val borderColor = if (isFocused) VerdoGreen else Color.LightGray.copy(alpha = 0.3f)

    Box(
        modifier = Modifier
            .size(60.dp)
            .background(Color.White, RoundedCornerShape(12.dp))
            .border(1.dp, borderColor, RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = digit,
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            color = Color.Black
        )
    }
}

@Composable
fun ResendCodeTimer(
    countdown: Int,
    onResend: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = if (countdown > 0) "Resend code in " else "Resend code",
            color = Color.Black.copy(alpha = 0.7f),
            style = MaterialTheme.typography.bodyLarge
        )

        if (countdown > 0) {
            Text(
                text = "$countdown s",
                color = VerdoGreen,
                fontWeight = FontWeight.Bold
            )
        } else {
            Text(
                text = " now",
                color = VerdoGreen,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { onResend() }
            )
        }
    }
}

@Composable
fun NextButtonContainer(
    buttonText: String,
    isEnabled: Boolean,
    onNext: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Button(
            onClick = { onNext() },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            enabled = isEnabled,
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = VerdoGreen)
        ) {
            Text(
                buttonText,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                fontSize = 18.sp
            )
        }
    }
}
