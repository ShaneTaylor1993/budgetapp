package com.example.budgetingapp.data.repository

import com.example.budgetingapp.data.AppDataBase
import com.example.budgetingapp.data.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepo @Inject constructor(private val database: AppDataBase) {

    private val userDao = database.userDao()
    suspend fun getUser(name: String?) {
        withContext(Dispatchers.IO) {
            //userDao.getExistingNames()
        }
    }

    suspend fun addUser(user: User) {
        withContext(Dispatchers.IO) {
            userDao.createUser(user)
        }
    }

    suspend fun getName(name: String) {
        withContext(Dispatchers.IO) {
            userDao.getUserName(name)
        }
    }
}