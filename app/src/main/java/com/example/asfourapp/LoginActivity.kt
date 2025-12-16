package com.example.asfourapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mail = "chrinoren@gmail.com"
        val passwordM = "123456789"

        val inputMailValue = findViewById<EditText>(R.id.emailInput)
        val inputPasswordValue = findViewById<EditText>(R.id.passwordInput)
        val bttonLogin = findViewById<Button>(R.id.loginButton)

        bttonLogin.setOnClickListener {
            val email = inputMailValue.text.toString().trim()
            val passwordV = inputPasswordValue.text.toString().trim()

            if (email == mail && passwordV == passwordM) {
                Log.d("LOGIN", "Login success")
                startActivity(Intent(this, home::class.java))
            } else {
                Log.d("LOGIN", "Login failed")
            }
        }

        val registerWay = findViewById<TextView>(R.id.registerText)
        registerWay.setOnClickListener {
            startActivity(Intent(this, signUp::class.java))
        }
    }
}
