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

object UserInfo : Destinations {
    override val route = "user_info/{name}"
}