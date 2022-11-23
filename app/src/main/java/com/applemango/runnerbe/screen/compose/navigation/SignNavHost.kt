package com.applemango.runnerbe.screen.compose.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.applemango.runnerbe.screen.compose.login.LoginView
import com.applemango.runnerbe.screen.compose.login.SplashViewModel

@Composable
fun SignNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginView(navController)
        }
    }
}