package com.example.testapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.network.models.Countries
import com.example.testapp.repository.CountriesRepository
import kotlinx.coroutines.launch

class CountriesActivityViewModel : ViewModel() {
    private val countriesRepository = CountriesRepository()

    private val _listOfCountries =
        MutableLiveData<List<Countries>?>()
    val listOfCountries: LiveData<List<Countries>?> = _listOfCountries

    init {
        viewModelScope.launch {
            _listOfCountries.value = countriesRepository.getListOfCountries()
        }
    }
}