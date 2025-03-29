package com.example.testapp.repository

import com.example.testapp.network.models.Countries

interface ICountriesRepository {
    suspend fun getListOfCountries(): List<Countries>?
}