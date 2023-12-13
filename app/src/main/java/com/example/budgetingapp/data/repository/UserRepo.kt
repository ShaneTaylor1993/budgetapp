package com.example.budgetingapp.data.repository

import com.example.budgetingapp.data.AppDataBase
import com.example.budgetingapp.data.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepo @Inject constructor(private val database: AppDataBase) {

    private val userDao = database.userDao()

    suspend fun getUser(name: String): Flow<User> {
        return withContext(Dispatchers.IO) {
            userDao.getUser(name)
        }
    }

    suspend fun addUser(user: User) {
        withContext(Dispatchers.IO) {
            userDao.createUser(user)
        }
    }
}