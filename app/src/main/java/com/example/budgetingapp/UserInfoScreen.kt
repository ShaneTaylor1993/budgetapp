package com.example.budgetingapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.budgetingapp.data.User
import com.example.budgetingapp.screens.viewModel.UserViewModel

@Composable
fun UserInfoScreen(name: String) {

    val vm: UserViewModel = hiltViewModel()
    val user = vm.state.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Text(text = "Hello ${user.value.name}")
//        Text(text = "You are ${age}")
//        Text(text = "Your fav color is ${user.value?.favColor}")
    }
}