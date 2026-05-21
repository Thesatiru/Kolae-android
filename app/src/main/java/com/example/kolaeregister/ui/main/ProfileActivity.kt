package com.example.kolaeregister.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kolaeregister.R
import com.example.kolaeregister.ui.quadra.BuscarActivity
import com.example.kolaeregister.ui.quadra.HomeActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        val rootView = findViewById<View>(R.id.profile)
        if (rootView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }


        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNavigation.selectedItemId = R.id.nav_perfil

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId){
                R.id.nav_pesquisar ->{
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_explorer ->{
                    val intent = Intent(this, BuscarActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }

        }
    }
}