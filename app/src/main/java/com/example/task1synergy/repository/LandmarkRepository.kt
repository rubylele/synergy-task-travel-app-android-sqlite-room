package com.example.task1synergy.repository


import androidx.lifecycle.LiveData
import com.example.task1synergy.model.Landmark
import com.example.task1synergy.data.LandmarkDao

class LandmarkRepository (private val landmarkDao: LandmarkDao){

    val getLandmark: LiveData<List<Landmark>> = landmarkDao.getLandmark()

    suspend fun addLandmark(landmark: Landmark){
        landmarkDao.addLandmark(landmark)
    }
}
