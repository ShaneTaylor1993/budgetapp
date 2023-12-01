package com.example.budgetingapp.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "incomes",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["name"],
        childColumns = ["userName"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Income(
    @PrimaryKey val id: Int = 0,
    val amount: Int,
    val name: String
)

@Entity(
    tableName = "expenses",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["name"],
        childColumns = ["userName"],
        onDelete = ForeignKey.CASCADE
    )]
) data class Expense(
    @PrimaryKey val id: Int = 0,
    val amount: Int,
    val name: String
)

@Entity(tableName = "users")
data class User(
    @PrimaryKey val name: String
)