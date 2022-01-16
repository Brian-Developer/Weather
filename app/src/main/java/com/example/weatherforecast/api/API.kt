package com.example.weatherforecast.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    private var retrofit : Retrofit? = null
    val apiService : APIService
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(APIService::class.java)
        }
}