package com.example.testapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.databinding.ActivityCountriesBinding
import kotlinx.coroutines.launch

class CountriesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCountriesBinding
    private val viewModel by lazy { ViewModelProvider(this)[CountriesActivityViewModel::class.java] }
    private lateinit var adapter: CountriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountriesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initAdapter()

        lifecycleScope.launch {
            viewModel.listOfCountries.observe(this@CountriesActivity) { list ->
                if (list.isNullOrEmpty()) {
                    Toast.makeText(
                        this@CountriesActivity,
                        "Something went wrong...",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    adapter.submitList(list)
                }
            }
        }
    }

    private fun initAdapter() {
        adapter = CountriesAdapter(listOfCountries = listOf())
        binding.listOfCountries.adapter = adapter
        binding.listOfCountries.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@CountriesActivity)
        }
    }
}