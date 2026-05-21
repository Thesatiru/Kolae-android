package com.example.kolaeregister.ui.quadra

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels // <-- Certifique-se de que este import está aqui
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kolaeregister.R
import com.example.kolaeregister.ui.adapter.QuadraAdapter
import com.example.kolaeregister.ui.auth.LoginActivity
import com.example.kolaeregister.ui.main.ProfileActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private val viewModel: QuadraViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val rvQuadras = findViewById<RecyclerView>(R.id.rvQuadras)
        rvQuadras.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val rvMaisAvaliadas = findViewById<RecyclerView>(R.id.rvMaisAvaliadas)
        rvMaisAvaliadas.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        viewModel.quadrasPerto.observe(this) { listaPerto ->
            rvQuadras.adapter = QuadraAdapter(listaPerto)
        }

        viewModel.quadrasMaisAvaliadas.observe(this) { listaMaisAvaliadas ->
            rvMaisAvaliadas.adapter = QuadraAdapter(listaMaisAvaliadas)
        }

        viewModel.carregarDadosHome()

        val btnAvancar = findViewById<View>(R.id.btnAvancarFluxo)
        btnAvancar.setOnClickListener {
            val intent = Intent(this, BuscarActivity::class.java)
            startActivity(intent)
        }

        val btnVoltar = findViewById<View>(R.id.btnVoltarFluxo)
        btnVoltar.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId){

                R.id.nav_explorer ->{
                    val intent = Intent(this, BuscarActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_perfil ->{
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }

        }
    }
}