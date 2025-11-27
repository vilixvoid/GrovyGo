package com.gogrocery.grocygo.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gogrocery.grocygo.ui.screens.account_setup.FillBioScreen
import com.gogrocery.grocygo.ui.screens.auth.SignInScreen
import com.gogrocery.grocygo.ui.screens.auth.SignUpScreen
import com.gogrocery.grocygo.ui.screens.onboarding.OnboardingScreen
import com.gogrocery.grocygo.ui.screens.onboarding.SplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = "splash"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        // --- SPLASH SCREEN ---
        composable("splash") {
            SplashScreen(
                onFinish = {
                    navController.navigate("onboarding") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )
        }

        // --- ONBOARDING ---
        composable("onboarding") {
            OnboardingScreen(
                onNext = {
                    navController.navigate("login")
                }
            )
        }

        // --- LOGIN / SIGN IN ---
        composable("login") {
            SignInScreen(
                onSignup = {
                    navController.navigate("signup")
                },
                onSignInSuccess = {
                    // nanti arahkan ke home
                    navController.navigate("fill_bio")
                }
            )
        }

        // --- SIGN UP ---
        composable("signup") {
            SignUpScreen(
                onBack = {
                    navController.popBackStack()
                },
                onSignUpSuccess = {
                    navController.navigate("fill_bio") {
                        popUpTo("signup") { inclusive = true }
                    }
                }
            )
        }

        // --- FILL BIO SCREEN ---
        composable("fill_bio") {
            FillBioScreen(
                onBack = {
                    navController.popBackStack()
                },
                onNext = {
                    // nanti diarahkan ke home atau complete-profile
                    // contoh sementara:
                    navController.navigate("home") {
                        popUpTo("fill_bio") { inclusive = true }
                    }
                }
            )
        }
    }
}
