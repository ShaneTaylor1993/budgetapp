package com.example.budgetingapp.screens.viewModel

import androidx.lifecycle.ViewModel
import com.example.budgetingapp.data.repository.UserRepo
import javax.inject.Inject

class UserInfoViewModel @Inject constructor(private val userRepo: UserRepo): ViewModel() {
}