package com.example.kolaeregister.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.kolaeregister.data.model.User
import com.example.kolaeregister.repository.UserRepository
import kotlinx.coroutines.launch

class ProfileViewModel (private val repository: UserRepository): ViewModel(){
    private val _userProfile = MutableLiveData<User?>()
    val userProfile: LiveData<User?> = _userProfile

    fun loadUserProfile(userId: Int) {
        viewModelScope.launch {
            val user = repository.getUserById(userId)
            _userProfile.value = user
        }
    }
}

class ProfileViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass : Class<T>): T{
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)){
            return ProfileViewModel(repository) as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida: ${modelClass.name}")
    }

}