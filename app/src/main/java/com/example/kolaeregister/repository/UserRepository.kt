package com.example.kolaeregister.repository

import com.example.kolaeregister.data.dao.UserDao
import com.example.kolaeregister.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository (private val userDao: UserDao) {
    suspend fun getUserById(id: Int): User?{
        return withContext(Dispatchers.IO){
            userDao.getUserById(id)
        }
    }

    suspend fun updateUser(user: User){
        withContext(Dispatchers.IO){
            userDao.updateUser(user)
        }
    }
}