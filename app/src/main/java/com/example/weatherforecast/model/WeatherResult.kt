package com.example.weatherforecast.model

data class WeatherResult (
    val city: City,
    val cod: String,
    val message: Double,
    val cnt: Long,
    val list: List<ListElement>
)

data class City(
    val id: Long,
    val name: String,
    val coord: Coord,
    val country: String,
    val population: Long,
    val timezone: Long
)

data class Coord (
    val lon: Double,
    val lat: Double
)

data class ListElement (
    val dt: Long,
    val sunrise: Long,
    val sunset: Long,
    val temp: Temp,

    val feelsLike: FeelsLike,

    val pressure: Long,
    val humidity: Long,
    val weather: List<Weather>,
    val speed: Double,
    val deg: Long,
    val gust: Double,
    val clouds: Long,
    val pop: Double,
    val rain: Double? = null
)

data class FeelsLike (
    val day: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
)

data class Temp (
    val day: Double,
    val min: Double,
    val max: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
)

data class Weather (
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
)

data class ErrorResponse (
    val cod: String,
    val message: String
)

