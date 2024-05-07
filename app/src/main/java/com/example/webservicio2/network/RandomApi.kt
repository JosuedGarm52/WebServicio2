package com.example.webservicio2.network

import com.example.webservicio2.models.RandomUse
import retrofit2.http.GET

interface RandomApi {
    @GET("api/")
    suspend fun getRandomUser(): RandomUse
}