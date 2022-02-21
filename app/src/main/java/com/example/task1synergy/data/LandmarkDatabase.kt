package com.example.task1synergy.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.task1synergy.model.Landmark

@Database(entities = [Landmark::class], version = 1, exportSchema = false)
abstract class LandmarkDatabase: RoomDatabase() {

    abstract fun landmarkDao(): LandmarkDao

    companion object{
        @Volatile
        private var INSTANCE: LandmarkDatabase? = null

        fun getDatabase(context: Context): LandmarkDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LandmarkDatabase::class.java,
                    "landmark_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}