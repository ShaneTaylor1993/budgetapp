package com.example.budgetingapp.data

import com.example.budgetingapp.data.User
import kotlinx.coroutines.flow.Flow

data class UserState(
    val user: Flow<User>? = null
)
