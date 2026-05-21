package com.example.kolaeregister.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kolaeregister.data.model.User
import com.example.kolaeregister.repository.AuthRepository

class LoginViewModel (private val repository: AuthRepository) : ViewModel(){
    fun doLogin(email: String,pass: String): User?{
        if (email.isBlank() || pass.isBlank()){
            android.util.Log.e("LOGIN","ERRO: Campos obrigatórios vazios!")
            return null
        }
        return repository.loginUser(email,pass)
    }
}

class LoginViewModelFactory(private val repository: AuthRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(repository) as T
        }

        throw IllegalArgumentException("Classe ViewModel desconhecida")
    }
 }