package com.example.weatherforecast.model

object Key {

    init {
        System.loadLibrary("native-lib")
    }

    external fun apiKey(): String
}