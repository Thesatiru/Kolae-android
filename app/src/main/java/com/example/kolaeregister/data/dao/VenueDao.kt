package com.example.kolaeregister.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kolaeregister.data.model.Venue

@Dao
interface VenueDao {
    @Query("SELECT * FROM venues")
    fun getAllVenues(): List<Venue>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVenues(venues: List<Venue>)
}