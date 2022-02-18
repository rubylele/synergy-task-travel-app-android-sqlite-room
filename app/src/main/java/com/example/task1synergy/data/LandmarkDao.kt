package com.example.task1synergy.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface LandmarkDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLandmark(landmark: Landmark)

    @Transaction
    @Query("SELECT * FROM landmarks_table ORDER BY landmarkId ASC")
    fun getLandmark(): LiveData<List<Landmark>>
}
