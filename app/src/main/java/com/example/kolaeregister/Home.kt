package com.example.kolaeregister// Mantenha o seu pacote original aqui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // --- LISTA 1: QUADRAS PERTO DE VOCÊ ---
        val minhasQuadras = listOf(
            Quadra("Sesc - São Paulo", "Gratuito", "5,0"),
            Quadra("Quadra do Xuxa - Suzano", "R$ 120/h", "4,8"),
            Quadra("Silver Arena", "R$ 80/h", "4,5"),
            Quadra("Arena Suzano", "Gratuito", "5,0")
        )

        // Achamos a primeira lista e configuramos
        val rvQuadras = findViewById<RecyclerView>(R.id.rvQuadras)
        rvQuadras.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvQuadras.adapter = QuadraAdapter(minhasQuadras)


        // --- LISTA 2: MAIS AVALIADAS ---
        // 1. Criamos os dados da segunda lista
        val quadrasMaisAvaliadas = listOf(
            Quadra("SESI - Suzano", "Gratuito", "5,0"),
            Quadra("Arena Suzano - Suzano", "Gratuito", "5,0"),
            Quadra("Ibirapuera", "Gratuito", "4,9")
        )

        // 2. Achamos a segunda lista pelo ID novo que criamos no XML
        val rvMaisAvaliadas = findViewById<RecyclerView>(R.id.rvMaisAvaliadas)

        // 3. Avisamos que ela também rola para o lado (Horizontal)
        rvMaisAvaliadas.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // 4. Ligamos os dados usando o MESMO Adapter da primeira lista!
        rvMaisAvaliadas.adapter = QuadraAdapter(quadrasMaisAvaliadas)

        val btnAvancar = findViewById<View>(R.id.btnAvancarFluxo)
        btnAvancar.setOnClickListener {
            val intent = Intent(this, BuscarActivity::class.java)
            startActivity(intent)
        }

        val btnVoltar = findViewById<View>(R.id.btnVoltarFluxo)
        btnVoltar.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}