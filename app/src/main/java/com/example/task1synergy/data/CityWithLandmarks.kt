package com.example.task1synergy.data

import androidx.room.Embedded
import androidx.room.Relation

data class CityWithLandmarks(
    @Embedded val city: City,
    @Relation(
        parentColumn = "cityId",
        entityColumn = "cityLandmarkId"
    )
    val landmarks: List<Landmark>
)