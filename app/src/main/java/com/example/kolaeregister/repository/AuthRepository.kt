package com.example.kolaeregister.repository

import com.example.kolaeregister.data.dao.UserDao
import com.example.kolaeregister.data.model.User

class AuthRepository (private val userDao: UserDao){
    fun registerNewUser(user: User): Long{
        return userDao.registerUser(user)
    }

    fun loginUser(email: String, pass: String): User? {
        return userDao.login(email, pass)
    }
}