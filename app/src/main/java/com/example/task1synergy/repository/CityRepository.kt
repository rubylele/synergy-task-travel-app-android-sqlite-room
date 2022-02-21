package com.example.task1synergy.repository

import androidx.lifecycle.LiveData
import com.example.task1synergy.model.City
import com.example.task1synergy.data.CityDao

class CityRepository(private val cityDao: CityDao) {

    val getCity: LiveData<List<City>> = cityDao.getCity()

    suspend fun addCity(city: City){
        cityDao.addCity(city)
    }
}