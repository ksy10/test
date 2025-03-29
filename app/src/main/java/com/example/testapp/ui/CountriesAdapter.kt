package com.example.testapp.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.databinding.ViewCountryBinding
import com.example.testapp.network.models.Countries

class CountriesAdapter(private var listOfCountries: List<Countries>) :
    RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {

    class CountriesViewHolder(private val countriesBinding: ViewCountryBinding) :
        RecyclerView.ViewHolder(countriesBinding.root) {
        fun bind(country: Countries) {
            countriesBinding.name.text = country.name
            countriesBinding.region.text = country.region
            countriesBinding.code.text = country.code
            countriesBinding.capital.text = country.capital
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewCountryBinding.inflate(inflater)
        return CountriesViewHolder(binding)
    }

    override fun getItemCount(): Int = listOfCountries.size

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.bind(listOfCountries[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: List<Countries>) {
        listOfCountries = newList
        notifyDataSetChanged()
    }
}