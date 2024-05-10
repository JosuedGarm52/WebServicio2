package com.example.webservicio2.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetroFitObject {
    val randomApi = Retrofit.Builder()
        .baseUrl("https://randomuser.me/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RandomApi :: class.java)// es de tipo randomApi

    val url_rickandmorty = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RickAndMortyApi :: class.java)
}