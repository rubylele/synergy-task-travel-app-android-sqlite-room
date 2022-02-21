package com.example.task1synergy.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "landmarks_table")
data class Landmark(
    @PrimaryKey val landmarkId: Int,
    val cityLandmarkId: Int,
    val landmarkName: String,
    val landmarkDescription: String
)
