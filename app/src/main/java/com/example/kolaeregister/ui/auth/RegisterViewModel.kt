package com.example.kolaeregister.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kolaeregister.data.model.User
import com.example.kolaeregister.repository.AuthRepository

class RegisterViewModel (private val repository: AuthRepository) : ViewModel(){

    // Mudamos a função para retornar true (se deu certo) ou false (se as senhas não batem)
    fun registerUser(name: String, email: String, pass: String, confirmPass: String, birthdate: String): Boolean {

        if (pass != confirmPass){
            android.util.Log.e("CADASTRO","Erro: As senhas não coincidem!")
            return false
        }

        val newUser = User(
            name = name,
            email = email,
            password = pass,
            birthdate = birthdate,
            role = "Player",
            status = "Active",
            cnpj = null,
            avatarPath = null,
            forcePasswordChange = 0,
            emailVerifiedAt = null,
            rememberToken = null,
        )

        repository.registerNewUser(newUser)
        android.util.Log.d("CADASTRO","Usuário salvo com sucesso no banco!")
        return true
    }
}

class RegisterViewModelFactory(private val repository: AuthRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return RegisterViewModel(repository) as T
        }
        throw IllegalArgumentException ("Classe ViewModel desconhecida")
    }
}