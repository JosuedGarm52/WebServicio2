package com.example.webservicio2.Singleton

import com.example.webservicio2.models.RickAndMortyApi.Characters

object Singleton {
    val characters = mutableListOf<Characters>()
}