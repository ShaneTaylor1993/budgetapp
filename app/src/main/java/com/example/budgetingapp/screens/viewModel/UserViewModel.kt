package com.example.budgetingapp.screens.viewModel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.budgetingapp.data.User
import com.example.budgetingapp.data.UserEvent
import com.example.budgetingapp.data.UserState
import com.example.budgetingapp.data.repository.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepo: UserRepo): ViewModel() {

    private val _state = MutableStateFlow(User())
    val state: StateFlow<User> = _state

    fun getUser(name: String) {
        viewModelScope.launch {
            userRepo.getUser(name)
                .collect {
                    _state.value = it
                    println("#DEV $it")
                    println("#DEV ${_state.value}")
                    println("#DEV ${state.value.name}")
                }
        }
    }

    fun createNewUser(name: String, age: Int?, favColor: String?) {
        viewModelScope.launch {
            val user = User(name, age, favColor)
            userRepo.addUser(user)
        }
    }
}