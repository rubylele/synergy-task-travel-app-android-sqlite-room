package com.example.task1synergy.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.task1synergy.model.City

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCity(city: City)

    @Query("SELECT * FROM city_table ORDER BY cityId ASC")
    fun getCity(): LiveData<List<City>>

}
