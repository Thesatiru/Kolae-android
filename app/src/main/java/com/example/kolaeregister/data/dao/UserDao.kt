package com.example.kolaeregister.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.kolaeregister.data.model.User

@Dao
interface UserDao {


    @Insert
    fun registerUser(user: User): Long

    @Query("SELECT * FROM users WHERE email = :email AND status = 'active' LIMIT 1")
    fun getUserByEmail(email: String): User?


    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    fun getUserById(id: Int): User?

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE email = :email AND password = :password LIMIT 1")
    fun login(email: String, password: String): User?

    @Update
    suspend fun updateUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)
}

