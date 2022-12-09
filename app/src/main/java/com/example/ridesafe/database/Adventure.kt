package com.example.ridesafe.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "adventure_table")
data class Adventure (
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "Adventure ID") val AdventureID: Int?,
    @ColumnInfo(name = "Total Distance") val TotalDistance: Int?,
    @ColumnInfo(name = "Time Travelled") val TimeTravelled: Int?,
    @ColumnInfo(name = "Route Taken") val RouteTaken: String?
    )