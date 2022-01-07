package com.example.hackio

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("api/v1/all")
    suspend fun getRecipe() : Response<Contests>
}