package com.example.kolaeregister.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.kolaeregister.R
import com.example.kolaeregister.data.AppDatabase
import com.example.kolaeregister.repository.AuthRepository

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro)

        val db = AppDatabase.getDatabase(this)
        val repository = AuthRepository(db.userDao())

        val factory = RegisterViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[RegisterViewModel::class.java]

        val botaoCadastrar = findViewById<View>(R.id.btn_criar_conta)

        val campoNome = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.edt_nome)
        val campoEmail = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.edt_email)
        val campoBithdate = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.edt_birthdate)
        val campoPassword = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.edt_password)
        val campoConfirmPass = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.edt_password_confirm)


        botaoCadastrar.setOnClickListener {
            val nome = campoNome.text.toString()
            val email = campoEmail.text.toString()
            val birthdate = campoBithdate.text.toString()
            val password = campoPassword.text.toString()
            val confirmPass = campoConfirmPass.text.toString()


            Thread {
                try {
                    val sucesso = viewModel.registerUser(
                        name = nome,
                        email = email,
                        birthdate = birthdate,
                        pass = password,
                        confirmPass = confirmPass
                    )

                    if (sucesso) {
                        runOnUiThread {
                            val intent = Intent(this@CadastroActivity, LoginActivity::class.java)
                            startActivity(intent)
                            finish() // Fecha a CadastroActivity para ela sumir da pilha do botão "Voltar"
                        }
                    }
                } catch (e: Exception) {
                    android.util.Log.e("ERRO_BANCO", "Falhou ao salvar: ${e.message}")
                }
            }.start() //
        }


        val txtEntreAqui = findViewById<TextView>(R.id.txt_entre_aqui)

        txtEntreAqui.setOnClickListener {
            val intent = Intent(this@CadastroActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        val rootView = findViewById<View>(R.id.main)
        if (rootView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}