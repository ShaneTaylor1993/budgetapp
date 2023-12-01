package com.example.budgetingapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IncomeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(income: Income)

    @Query("SELECT SUM(amount) FROM incomes")
    suspend fun getTotalIncome(userName: String): List<Income>
}

@Dao
interface ExpenseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(expense: Expense)

    @Query("SELECT SUM(amount) FROM expenses")
    suspend fun getTotalExpense(userName: String): List<Expense>
}

@Dao
interface UserDao {
    @Query("SELECT name FROM users")
    suspend fun getName(name: String)

    @Insert(User::class)
    suspend fun createUser(name: String)
}