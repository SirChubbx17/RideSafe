package com.example.ridesafe.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Adventure::class], version = 1, exportSchema = false)
abstract class AdventureDatabase : RoomDatabase(){

    abstract fun adventureDao():AdventureDao

    companion object{
        @Volatile
        private var INSTANCE: AdventureDatabase? = null

        fun getDatabase(context: Context): AdventureDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AdventureDatabase::class.java,
                    "storage_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}