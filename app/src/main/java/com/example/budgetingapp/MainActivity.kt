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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.budgetingapp.navigation.Budget
import com.example.budgetingapp.navigation.Home
import com.example.budgetingapp.screens.BudgetingScreen
import com.example.budgetingapp.screens.viewModel.BudgetingViewModel
import com.example.budgetingapp.screens.UserScreen
import com.example.budgetingapp.ui.theme.BudgetingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm = BudgetingViewModel()
            BudgetApp(vm = vm)
        }
    }

    @Composable
    fun BudgetApp(vm: BudgetingViewModel) {
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
            startDestination = Home.route)
         {
            composable(route = Home.route) {
                UserScreen(
                    onNextClick = {
                        navController.navigateSingleTopTo(Budget.route)
                    }
                )
            }
             composable(route = Budget.route) {
                 BudgetingScreen()
             }

        }

    }

}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }
