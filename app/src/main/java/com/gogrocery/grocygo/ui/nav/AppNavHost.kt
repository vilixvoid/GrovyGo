package com.gogrocery.grocygo.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gogrocery.grocygo.ui.screens.onboarding.OnboardingScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = "onboarding"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable("onboarding") {
            OnboardingScreen(
                onNext = {
                    navController.navigate("login")
                }
            )
        }

        composable("login") {
            // sementara biar gak error
            androidx.compose.material3.Text("Login Screen")
        }
    }
}
