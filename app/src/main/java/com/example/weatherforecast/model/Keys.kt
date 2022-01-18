package com.example.weatherforecast.model

object Keys {

    init {
        System.loadLibrary("native-lib")
    }

    external fun apiKey(): String
}