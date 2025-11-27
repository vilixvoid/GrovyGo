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
import androidx.compose.ui.graphics.Color
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
fun SignUpScreen(
    onBack: () -> Unit,
    onSignUpSuccess: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    val lightGray = colorResource(id = R.color.light_gray)

    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            // BACKGROUND + LOGO
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

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {

                Text(
                    "Sign up for free",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                // EMAIL FIELD
                CustomInputField(
                    value = email,
                    onValueChange = { email = it },
                    label = "Email*",
                    placeholder = "Enter your email"
                )

                Spacer(modifier = Modifier.height(16.dp))

                // PASSWORD FIELD
                CustomInputField(
                    value = password,
                    onValueChange = { password = it },
                    label = "Password*",
                    placeholder = "Enter your password",
                    isPassword = true,
                    passwordVisible = passwordVisible,
                    onToggleVisibility = { passwordVisible = !passwordVisible }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // CONFIRM PASSWORD FIELD
                CustomInputField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = "Confirm Password*",
                    placeholder = "Re-enter your password",
                    isPassword = true,
                    passwordVisible = confirmPasswordVisible,
                    onToggleVisibility = { confirmPasswordVisible = !confirmPasswordVisible }
                )

                Spacer(modifier = Modifier.height(24.dp))

                // SIGN UP BUTTON
                Button(
                    onClick = { onSignUpSuccess() },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = VerdoGreen),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Sign Up", fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // DIVIDER SOCIAL LOGIN
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Divider(Modifier.weight(1f), color = lightGray)
                    Text(" or continue with ", color = lightGray)
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
            }

            // SIGN IN LINK
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Already have an account? ")
                Text(
                    "Sign in",
                    color = VerdoGreen,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { onBack() }
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SignUpPreview() {
    MaterialTheme {
        SignUpScreen(
            onBack = {},
            onSignUpSuccess = {}
        )
    }
}
