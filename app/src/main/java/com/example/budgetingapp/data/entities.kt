package com.example.budgetingapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

//@Entity(tableName = "incomes",)
//data class Income(
//    @PrimaryKey val id: Int = 0,
//    val amount: Int,
//    val name: String
//)
//
//@Entity(tableName = "expenses",)
//data class Expense(
//    @PrimaryKey val id: Int = 0,
//    val amount: Int,
//    val name: String
//)

@Entity(tableName = "users")
data class User(
    @PrimaryKey val name: String = "",
    @ColumnInfo(name = "age") val age: Int? = null,
    @ColumnInfo(name = "favorite_color") val favColor: String? = null
)