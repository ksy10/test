package com.example.testapp.repository

import android.util.Log
import com.example.testapp.network.RetrofitClient
import com.example.testapp.network.models.Countries

class CountriesRepository : ICountriesRepository {
    private val apiService = RetrofitClient.apiService

    override suspend fun getListOfCountries(): List<Countries>? {
        return try {
            val response = apiService.getCountries()
            response
        } catch (e: Exception) {
            Log.e("Request", e.message.toString())
            null
        }
    }
}