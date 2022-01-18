package com.example.weatherforecast


import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest {
    @Test
    fun correctInput(){
        val cityName = "hanoi"
        val result = Validator.validateInputCity(cityName)
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun failInput(){
        val cityName = "ab"
        val result = Validator.validateInputCity(cityName)
        assertThat(result).isEqualTo(false)
    }
}