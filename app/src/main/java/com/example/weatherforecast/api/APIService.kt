package com.example.weatherforecast.api

import com.example.weatherforecast.model.WeatherResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("data/2.5/forecast/daily")
    fun retrieve( @Query("q") q: String
                 ,@Query("cnt") cnt: String
                 ,@Query("appid") appid: String): Call<WeatherResult>
}