package com.example.kolaeregister.repository

import com.example.kolaeregister.data.dao.VenueDao
import com.example.kolaeregister.data.model.Venue

class VenueRepository(private val venueDao: VenueDao) {
    fun getAllVenues(): List<Venue>{
        return venueDao.getAllVenues()
    }

    fun saveVenues(venues: List<Venue>){
        venueDao.insertVenues(venues)
    }
}