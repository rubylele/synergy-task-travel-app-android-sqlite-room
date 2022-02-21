package com.example.task1synergy.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.task1synergy.data.LandmarkDatabase
import com.example.task1synergy.repository.LandmarkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LandmarkViewModel(application: Application): AndroidViewModel(application) {

    private val getLandmark: LiveData<List<Landmark>>
    private val repository: LandmarkRepository

    init {
        val landmarkDao = LandmarkDatabase.getDatabase(application).landmarkDao()
        repository = LandmarkRepository(landmarkDao)
        getLandmark = repository.getLandmark

    }

    fun addLandmark(landmark: Landmark){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addLandmark(landmark)
        }
    }

}
