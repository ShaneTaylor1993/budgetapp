package com.example.budgetingapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun userDao(): UserDao
//    abstract fun incomeDao(): IncomeDao
//    abstract fun expenseDao(): ExpenseDao
}