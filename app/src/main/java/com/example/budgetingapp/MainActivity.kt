package com.example.budgetingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.budgetingapp.navigation.Budget
import com.example.budgetingapp.navigation.Home
import com.example.budgetingapp.navigation.UserInfo
import com.example.budgetingapp.screens.UserScreen
import com.example.budgetingapp.ui.theme.BudgetingAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity() : ComponentActivity() {

    //private val vm: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudgetApp()
        }
    }

    @Composable
    fun BudgetApp() {
        BudgetingAppTheme {
            val navController = rememberNavController()
            val currentBackStack by navController.currentBackStackEntryAsState()
            val currentDestination = currentBackStack?.destination
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                AppNavHost(navController = navController)
            }
        }
    }

    @Composable
    fun AppNavHost(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = Home.route
        )
        {
            composable(route = Home.route) {
                UserScreen(
                    onNextClick = {
                        navController.navigateSingleTopTo(UserInfo.route)
                    }
                )
            }
            composable(route = UserInfo.route, arguments = listOf(navArgument("name") {type = NavType.StringType})) {
                val name = it.arguments?.getString("name")
                if (name != null) {
                    UserInfoScreen(name = name)
                }
            }

        }

    }

}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }