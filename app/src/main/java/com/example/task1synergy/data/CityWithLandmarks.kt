package com.example.task1synergy.data

import androidx.room.Embedded
import androidx.room.Relation
import com.example.task1synergy.model.City
import com.example.task1synergy.model.Landmark

data class CityWithLandmarks(
    @Embedded val city: City,
    @Relation(
        parentColumn = "cityId",
        entityColumn = "cityLandmarkId"
    )
    val landmarks: List<Landmark>
)
