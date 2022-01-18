package com.example.weatherforecast

object Validator {
    fun validateInputCity(cityName: String): Boolean {
        return cityName.trim().length >= 3
    }
}