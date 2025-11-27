package com.gogrocery.grocygo.ui.components.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gogrocery.grocygo.R
import com.gogrocery.grocygo.ui.theme.LightVerdoGreen
import com.gogrocery.grocygo.ui.theme.VerdoGreen


// ================================
// LOGO HEADER
// ================================
@Composable
fun AppLogoHeader() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.ic_grocygo_logo),
            contentDescription = null,
            modifier = Modifier.size(180.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppLogoHeader() {
    AppLogoHeader()
}

// ================================
// CUSTOM INPUT FIELD
// ================================
@Composable
fun CustomInputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    isPassword: Boolean = false,
    passwordVisible: Boolean = false,
    onToggleVisibility: () -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
            color = Color.Black,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(placeholder, color = Color.Gray) },
            shape = RoundedCornerShape(12.dp),
            visualTransformation =
                if (isPassword && !passwordVisible) PasswordVisualTransformation()
                else VisualTransformation.None,
            trailingIcon = if (isPassword) {
                {
                    IconButton(onClick = onToggleVisibility) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = null,
                            tint = VerdoGreen
                        )
                    }
                }
            } else null,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = VerdoGreen,
                unfocusedBorderColor = Color.LightGray.copy(alpha = 0.5f),
                focusedContainerColor = LightVerdoGreen,
                unfocusedContainerColor = LightVerdoGreen,
                cursorColor = VerdoGreen
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomInputField() {
    var text by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(false) }

    CustomInputField(
        value = text,
        onValueChange = { text = it },
        label = "Password",
        placeholder = "Enter password",
        isPassword = true,
        passwordVisible = visible,
        onToggleVisibility = { visible = !visible }
    )
}

// ================================
// SOCIAL LOGIN BUTTON
// ================================
@Composable
fun SocialLoginButton(text: String, iconRes: Int, modifier: Modifier = Modifier) {
    OutlinedButton(
        onClick = {},
        modifier = modifier.height(50.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSocialLoginButton() {
    SocialLoginButton(
        text = "Continue with Google",
        iconRes = R.drawable.ic_google,
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    )
}

// ================================
// SOCIAL LOGIN SECTION (Google + Facebook)
// ================================
@Composable
fun SocialLoginSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        SocialLoginButton(
            text = "Continue with Google",
            iconRes = R.drawable.ic_google,
            modifier = Modifier.fillMaxWidth()
        )

        SocialLoginButton(
            text = "Continue with Facebook",
            iconRes = R.drawable.ic_facebook,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSocialLoginSection() {
    SocialLoginSection()
}
