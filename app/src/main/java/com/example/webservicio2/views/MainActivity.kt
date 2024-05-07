package com.example.webservicio2.views

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.webservicio2.R
import com.example.webservicio2.viewModel.MainActivityViewModel
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        mainActivityViewModel.randomUser.observe(this){
            Toast.makeText(this,"Name: ${it.results.first().name}", Toast.LENGTH_LONG).show()
            Log.d(this.localClassName,"Name ${it.results.first().name}")
            val tvTitle = findViewById<TextView>(R.id.tvTitulo)
            val tvFirst = findViewById<TextView>(R.id.tvFirst)
            val tvLast = findViewById<TextView>(R.id.tvLast)

            tvTitle.text = it.results.first().name.title
            tvFirst.text = it.results.first().name.first
            tvLast.text = it.results.first().name.last
        }

        mainActivityViewModel.getRandomUser()
    }
}