package com.example.kolaeregister.ui.quadra

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels // <-- Certifique-se de que este import está aqui
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kolaeregister.R
import com.example.kolaeregister.data.AppDatabase
import com.example.kolaeregister.repository.VenueRepository
import com.example.kolaeregister.ui.adapter.QuadraAdapter
import com.example.kolaeregister.ui.auth.LoginActivity
import com.example.kolaeregister.ui.main.ProfileActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var venueViewModel: VenueViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val db = AppDatabase.getDatabase(this)
        val repository = VenueRepository(db.venueDao())
        val factory = VenueViewModelFactory(repository)

        venueViewModel = ViewModelProvider(this,factory)[VenueViewModel::class.java]

        val nomeRecebido = intent.getStringExtra("USER_NAME") ?: "Usuário"

        val rvQuadras = findViewById<RecyclerView>(R.id.rvQuadras)
        rvQuadras.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val rvMaisAvaliadas = findViewById<RecyclerView>(R.id.rvMaisAvaliadas)
        rvMaisAvaliadas.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        venueViewModel.quadrasPerto.observe(this){

            maisPerto -> rvQuadras.adapter = QuadraAdapter(maisPerto)
        }

        venueViewModel.quadrasMaisAvaliadas.observe(this){
            maisAvaliadas -> rvMaisAvaliadas.adapter = QuadraAdapter(maisAvaliadas)
        }

        venueViewModel.carregarDadosHome()



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