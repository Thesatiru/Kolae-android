package com.example.kolaeregister.repository

import com.example.kolaeregister.model.Quadra

class QuadraRepository {
    fun buscarQuadrasFicticias(): List<Quadra>{
        return listOf(
            Quadra("Arena central","R$ 120/h", "4.8"),
            Quadra("Quadra do Xuxa","R$ 85/h", "4.8"),
            Quadra("Quadra ruim","R$ 200/h", "3.2"),
            Quadra("Super quadra beach tenis","R$ 90/h", "4.8"),
            Quadra("Arena Maluca","R$ 45/h", "4.9"),
            Quadra("Arena Leoes de Ferraz","R$ 45/h", "5.0")
        )
    }
}