package com.example.budgetingapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent

@Database(entities = [User::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun userDao(): UserDao
//    abstract fun incomeDao(): IncomeDao
//    abstract fun expenseDao(): ExpenseDao
}