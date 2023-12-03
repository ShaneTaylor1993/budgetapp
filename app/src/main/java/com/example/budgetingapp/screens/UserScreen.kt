package com.example.budgetingapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.budgetingapp.screens.viewModel.UserViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(
    onNextClick: () -> Unit = {}
) {
    val vm: UserViewModel = hiltViewModel()
    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ) {
        // Text above the text box
        Text(
            text = "Who are you?",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Text box for entering name
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Button(
            onClick = {
                onNextClick()
                vm.getUserInfo(name)
            }
            ) {
            Text(text = "Next")
        }

        NewUserInfo(
            onNextClick,
            vm
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewUserInfo(
    onNextClick: () -> Unit,
   vm: UserViewModel
    ) {

    var newUser by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var favColor by remember { mutableStateOf("") }
    
    Spacer(modifier = Modifier.padding(16.dp))

    Text(
        text = "New here?",
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        modifier = Modifier.padding(bottom = 16.dp)
    )

    OutlinedTextField(
        value = newUser,
        onValueChange = { newUser = it },
        label = { Text("Name") },
        modifier = Modifier.fillMaxWidth()
    )

    OutlinedTextField(
        value = age,
        onValueChange = { age = it },
        label = { Text("Age") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    OutlinedTextField(
        value = favColor,
        onValueChange = { favColor = it },
        label = { Text("Favorite Color") },
        modifier = Modifier.fillMaxWidth()
    )

    Button(
        onClick = {
            vm.createNewUser(newUser, age.toInt(), favColor)
            onNextClick()
        },
        enabled = newUser.isNotEmpty()
    ) {
        Text(text = "Next")
    }

}