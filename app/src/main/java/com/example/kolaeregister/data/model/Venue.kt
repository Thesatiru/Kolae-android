package com.example.kolaeregister.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "venues")
data class Venue(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val subtitle: String,
    val description: String,
    val imageUrl: String,
    val location: String,
    val pricePerHour: Double? = null,
    val rating: Double = 0.0,
    val numberRatings: Int,
    val owner: String,
    val imgOwnerUrl: String,
    val monthsOnApp: Int
) : Serializable
