package com.example.kolaeregister

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BuscarActivity : AppCompatActivity() {
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
            startActivity(Intent(this, InfomacaoActivity::class.java))
        }

        val btnVoltar = findViewById<View>(R.id.btnVoltarFluxo)
        btnVoltar.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
    }
}