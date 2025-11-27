package com.gogrocery.grocygo.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gogrocery.grocygo.R
import com.gogrocery.grocygo.ui.components.auth.AppLogoHeader
import com.gogrocery.grocygo.ui.components.auth.CustomInputField
import com.gogrocery.grocygo.ui.components.auth.SocialLoginButton
import com.gogrocery.grocygo.ui.theme.VerdoGreen

@Composable
fun SignInScreen(
    onSignup: () -> Unit,
    onSignInSuccess: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val lightGray = colorResource(id = R.color.light_gray)

    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            // ============================
            // HEADER BACKGROUND + LOGO
            // ============================
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bg_splash_grocery),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    AppLogoHeader()
                }
            }

            // ============================
            // FORM SECTION
            // ============================
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {

                Text(
                    "Sign in to your account",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Email
                CustomInputField(
                    value = email,
                    onValueChange = { email = it },
                    label = "Email",
                    placeholder = "Enter your email"
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Password
                CustomInputField(
                    value = password,
                    onValueChange = { password = it },
                    label = "Password",
                    placeholder = "Enter password",
                    isPassword = true,
                    passwordVisible = passwordVisible,
                    onToggleVisibility = { passwordVisible = !passwordVisible }
                )

                Spacer(modifier = Modifier.height(24.dp))

                // LOGIN BUTTON
                Button(
                    onClick = { onSignInSuccess() },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = VerdoGreen),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Login", fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // DIVIDER (SOCIAL)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Divider(Modifier.weight(1f), color = lightGray)
                    Text("  or continue with  ", color = lightGray)
                    Divider(Modifier.weight(1f), color = lightGray)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // SOCIAL LOGIN BUTTONS
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    SocialLoginButton(
                        text = "Facebook",
                        iconRes = R.drawable.ic_facebook,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    SocialLoginButton(
                        text = "Google",
                        iconRes = R.drawable.ic_google,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // SIGN UP NAV
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text("Don't have an account? ")
                    Text(
                        "Sign up",
                        color = VerdoGreen,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable { onSignup() }
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginPreview() {
    MaterialTheme {
        SignInScreen(
            onSignup = {},
            onSignInSuccess = {}
        )
    }
}
