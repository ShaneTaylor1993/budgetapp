package com.example.budgetingapp.data

sealed interface UserEvent {
    data object SaveUser: UserEvent
    data class GetUser(val name: String? = "") : UserEvent
}