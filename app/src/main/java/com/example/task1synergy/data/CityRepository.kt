package com.example.task1synergy.data

import androidx.lifecycle.LiveData

class CityRepository(private val cityDao: CityDao) {

    val getCity: LiveData<List<City>> = cityDao.getCity()

    suspend fun addCity(city: City){
        cityDao.addCity(city)
    }
}