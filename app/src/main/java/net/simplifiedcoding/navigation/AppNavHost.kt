package net.simplifiedcoding.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.simplifiedcoding.ui.AnimatedSplashScreen
import net.simplifiedcoding.ui.Menu.MenuScreen
import net.simplifiedcoding.ui.Menuone.MenuOneScreen

import net.simplifiedcoding.ui.auth.AuthViewModel
import net.simplifiedcoding.ui.auth.LoginScreen
import net.simplifiedcoding.ui.auth.SignupScreen
import net.simplifiedcoding.ui.home.HomeScreen
import net.simplifiedcoding.ui.latest.LatestReportScreen
import net.simplifiedcoding.ui.report.ReportScreen

@Composable
fun AppNavHost(
    viewModel: AuthViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_ANIMATEDSPLASHSCREEN
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ROUTE_ANIMATEDSPLASHSCREEN) {
            AnimatedSplashScreen(viewModel, navController)
        }
        composable(ROUTE_MENUONE) {
            MenuOneScreen(viewModel, navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(viewModel, navController)
        }
        composable(ROUTE_SIGNUP) {
            SignupScreen(viewModel, navController)
        }
        composable(ROUTE_HOME) {
            HomeScreen(viewModel, navController)
        }
        composable(ROUTE_REPORT) {
            ReportScreen(viewModel, navController)
        }
        composable(ROUTE_MENU) {
            MenuScreen(viewModel, navController)
        }
        composable(ROUTE_LATESTREPORTSCREEN) {
            LatestReportScreen(viewModel, navController)
        }
    }
}