package com.example.kolaeregister.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.kolaeregister.ui.quadra.HomeActivity
import com.example.kolaeregister.R
import com.example.kolaeregister.data.AppDatabase
import com.example.kolaeregister.data.UserSession
import com.example.kolaeregister.repository.AuthRepository
import kotlin.concurrent.thread

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val db = AppDatabase.getDatabase(this)
        val repository = AuthRepository(db.userDao())
        val factory = LoginViewModelFactory(repository)
        val viewModel = ViewModelProvider(this,factory)[LoginViewModel::class.java]

        val campoEmail = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEmail)
        val campoPass = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etPassword)
        val botaoEntrar = findViewById<View>(R.id.btnEntrar)

        botaoEntrar.setOnClickListener {
            val email = campoEmail.text.toString()
            val pass = campoPass.text.toString()
                Thread {
                    try {
                        val usuarioLogado = viewModel.doLogin(email,pass)

                        runOnUiThread {
                            if (usuarioLogado != null){
                                Toast.makeText(this,"Bem-vindo, ${usuarioLogado.name}!", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, HomeActivity::class.java)
                                UserSession.userName = usuarioLogado.name
                                UserSession.userEmail = usuarioLogado.email
                                startActivity(intent)
                                finish()
                            } else{
                                Toast.makeText(this,"E-mail ou senha incorretos!", Toast.LENGTH_LONG).show()
                            }
                        }
                    }catch (e: Exception){
                        android.util.Log.e("ERRO_LOGIN","Erro ao processar o Login: ${e.message}")
                    }
                }.start()
            }


            val tvCreateAccount = findViewById<TextView>(R.id.tvCreateAccount)

            tvCreateAccount.setOnClickListener {
                val intent = Intent(this@LoginActivity, CadastroActivity::class.java)
                startActivity(intent)
            }

        val rootView = findViewById<View>(R.id.login)
        if (rootView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}