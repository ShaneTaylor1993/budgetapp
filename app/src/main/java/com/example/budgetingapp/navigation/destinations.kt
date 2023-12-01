package com.example.budgetingapp.navigation

interface Destinations {
    val route: String
}

object Home : Destinations {
    override val route = "home"
}

object Budget : Destinations {
    override val route = "budget"
}