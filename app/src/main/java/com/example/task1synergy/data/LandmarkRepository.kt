package com.example.task1synergy.data


import androidx.lifecycle.LiveData

class LandmarkRepository (private val landmarkDao: LandmarkDao){

    val getLandmark: LiveData<List<Landmark>> = landmarkDao.getLandmark()

    suspend fun addLandmark(landmark: Landmark){
        landmarkDao.addLandmark(landmark)
    }
}