package com.example.task1synergy.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city_table")
data class City(
    @PrimaryKey(autoGenerate = true) val cityId: Int,
    val cityName: String,
    val cityDescription: String,
    val cityAge: Int
)

