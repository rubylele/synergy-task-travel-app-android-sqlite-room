package com.example.task1synergy.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.task1synergy.data.CityDatabase
import com.example.task1synergy.repository.CityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CityViewModel(application: Application): AndroidViewModel(application) {

    private val getCity: LiveData<List<City>>
    private val repository: CityRepository

    init {
        val cityDao = CityDatabase.getDatabase(application).cityDao()
        repository = CityRepository(cityDao)
        getCity = repository.getCity

    }

    fun addCity(city: City){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCity(city)
        }
    }

}