package com.example.testapp.network

import com.example.testapp.network.models.Countries
import retrofit2.http.GET

interface ApiService {
    @GET("countries.json")
    suspend fun getCountries(): List<Countries>
}