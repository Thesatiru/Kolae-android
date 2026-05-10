package com.example.kolaeregister
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Linkando a Activity com o layout que criamos no Passo 1
        setContentView(R.layout.activity_welcome)

        // Encontrando o layout principal para tornar a tela inteira clicável
        val mainLayout = findViewById<View>(R.id.welcome)


        mainLayout.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            finish()
        }
    }
}