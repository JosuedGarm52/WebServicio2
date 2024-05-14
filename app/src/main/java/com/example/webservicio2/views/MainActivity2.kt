package com.example.webservicio2.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.webservicio2.R
import com.example.webservicio2.adapter.RickAndMortyAdapter
import com.example.webservicio2.models.RickAndMortyApi.Characters
import com.example.webservicio2.viewModel.RickAndMortyActivityViewModel
import android.util.Log

class MainActivity2 : AppCompatActivity() {

    lateinit var viewModel : RickAndMortyActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adaptador = RickAndMortyAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adaptador

        viewModel = ViewModelProvider(this)[RickAndMortyActivityViewModel::class.java]
        viewModel.characters.observe(this, Observer { characters ->
            Log.d("MainActivity", "Observer called with characters: $characters")
            characters?.let {
                Log.d("MainActivity", "Characters are not null, submitting list: ${it.results}")
                adaptador.submitList(it.results)
            } ?: run {
                Log.d("MainActivity", "Characters are null")
            }
        })

        viewModel.getCharacters()

        val botonIrMenu : Button = findViewById(R.id.btnMenu2)
        botonIrMenu.setOnClickListener{
            val intent = Intent(this, PrincipalActivity :: class.java)
            startActivity(intent)
        }
    }
    private fun onItemClick(charact: Characters) {
        // Manejar el clic en el elemento de tu RecyclerView
        Toast.makeText(this, "Clic a", Toast.LENGTH_SHORT).show()

    }
}