package com.example.kolaeregister.ui.auth

import android.content.Intent
import android.content.IntentSender
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.kolaeregister.ui.auth.CadastroActivity
import com.example.kolaeregister.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode(
            androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
        )

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_welcome)

        val progressBar = findViewById<ProgressBar>(R.id.progressBarWelcome)

        object : CountDownTimer(4000,40){
            override fun onTick(millisUntilFinished: Long){

                val tempoDecorrido = 4000 - millisUntilFinished
                val progresso = (tempoDecorrido * 100/4000).toInt()

                progressBar.progress = progresso
            }
            override fun onFinish(){
                progressBar.progress = 100
                val intent = Intent(this@WelcomeActivity, LoginActivity::class.java)
                startActivity(intent)

                finish()
            }
        }.start()
    }
}