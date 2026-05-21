package com.example.kolaeregister.ui.quadra

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kolaeregister.R
import com.example.kolaeregister.ui.main.ProfileActivity

import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlin.getValue

class BuscarActivity : AppCompatActivity() {

    private  val viewModel: VenueViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar)

        val rootView = findViewById<View>(R.id.buscar)
        if (rootView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        val btnAvancar = findViewById<View>(R.id.btnAvancarFluxo)
        btnAvancar.setOnClickListener {
            startActivity(Intent(this, InformationActivity::class.java))
        }

        val btnVoltar = findViewById<View>(R.id.btnVoltarFluxo)
        btnVoltar.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNavigation.selectedItemId = R.id.nav_explorer

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId){
                R.id.nav_pesquisar ->{
                    val intent = Intent(this, HomeActivity::class.java)
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