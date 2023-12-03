package com.example.budgetingapp.screens.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.budgetingapp.data.User
import com.example.budgetingapp.data.repository.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepo: UserRepo): ViewModel() {

    fun enterInfo(name: User) {
        viewModelScope.launch {
            val user = userRepo.addUser(name)
        }
    }

    fun createNewUser(name: String, age: Int?, favColor: String?) {
        viewModelScope.launch {
            val user = User(name, age, favColor)
            userRepo.addUser(user)

        }
    }

    fun getUserInfo(name: String) {
        viewModelScope.launch {
            val user = User(name)
            userRepo.getUser(user.name)
        }
    }

    fun getUserName(name: String) {
        // Use withContext to switch to the IO dispatcher
        viewModelScope.launch{
            userRepo.getName(name)
        }
    }

}