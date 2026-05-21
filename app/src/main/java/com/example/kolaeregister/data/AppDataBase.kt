package com.example.kolaeregister.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kolaeregister.data.dao.UserDao
import com.example.kolaeregister.data.dao.VenueDao
import com.example.kolaeregister.data.model.User
import com.example.kolaeregister.data.model.Venue

@Database(entities = [User::class, Venue::class], version = 5, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun venueDao(): VenueDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "kolae_database"

                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}