package com.example.webservicio2.network

import com.example.webservicio2.models.RickAndMortyApi.Characters
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("api/character")
    suspend fun getCharacters() : Characters
}