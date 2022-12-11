package com.example.ridesafe.database

import androidx.room.*

@Dao
interface AdventureDao {
    @Query("SELECT * FROM adventure_table")
    fun getAll(): List<Adventure>

    @Query("SELECT * FROM adventure_table WHERE id LIKE :id LIMIT 1")
    suspend fun findByRoute(id: Int): Adventure

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(storage: Adventure)

    @Delete
    suspend fun delete(storage: Adventure)

    @Query("DELETE FROM adventure_table")
    suspend fun deleteAll()

    @Query("UPDATE adventure_table SET `Total Distance`=:totaldistance,`Time Travelled`=:timetravelled WHERE id LIKE :id")
    suspend fun update(totaldistance : Int, timetravelled : Int, id : Int)

    @Query("DELETE FROM adventure_table WHERE id LIKE :id")
    suspend fun delete(id: Int)
}