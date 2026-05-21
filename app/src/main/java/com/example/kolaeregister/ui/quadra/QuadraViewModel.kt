package com.example.kolaeregister.ui.quadra

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kolaeregister.model.Quadra
import com.example.kolaeregister.repository.QuadraRepository

class QuadraViewModel : ViewModel() {
    private val repository = QuadraRepository()

    private val _quadrasPerto = MutableLiveData<List<Quadra>>()
    val quadrasPerto: LiveData<List<Quadra>> = _quadrasPerto

    private val _quadrasMaisAvaliadas = MutableLiveData<List<Quadra>>()
    val quadrasMaisAvaliadas: LiveData<List<Quadra>> = _quadrasMaisAvaliadas

    fun carregarDadosHome(){
        val todasAsQuadras = repository.buscarQuadrasFicticias()

        _quadrasPerto.value = todasAsQuadras.take(3)
        _quadrasMaisAvaliadas.value = todasAsQuadras.takeLast(3)
    }
}