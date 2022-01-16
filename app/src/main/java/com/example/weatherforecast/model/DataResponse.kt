package com.example.weatherforecast.model

data class DataResponse<T>(
    val responseSuccess : WeatherResult? = null,
    val responseFail : ErrorResponse? = null,
    val throwable: Throwable? = null,
)
