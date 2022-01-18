package com.example.weatherforecast.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherforecast.api.API
import com.example.weatherforecast.model.DataResponse
import com.example.weatherforecast.model.ErrorResponse
import com.example.weatherforecast.model.Key
import com.example.weatherforecast.model.WeatherResult
import com.google.gson.Gson
import okhttp3.internal.concurrent.TaskRunner
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val _responseData = MutableLiveData<DataResponse<WeatherResult>>()
    private var gson = Gson()
    private var jsonObject = JSONObject()

    val responseData : LiveData<DataResponse<WeatherResult>>
        get() = _responseData

    fun retrieveAPIData(cityName : String) {
        API.apiService.retrieve(cityName,"7" , Key.apiKey()).enqueue(object : Callback<WeatherResult> {
            override fun onResponse(call: Call<WeatherResult>, response: Response<WeatherResult>) {
                if (response.isSuccessful){
                    _responseData.postValue(DataResponse(response.body(), null))
                    Log.e("Result", response.body()!!.toString())
                } else {
                    jsonObject = JSONObject(response.errorBody()!!.string())
                    val error = gson.fromJson(jsonObject.toString(), ErrorResponse::class.java)
                    _responseData.postValue(DataResponse(null, error))
                    Log.e("Error result", error.message)
                }
            }

            override fun onFailure(call: Call<WeatherResult>, t: Throwable) {
                _responseData.postValue(DataResponse(null, null, t))
                Log.e("Throwable", t.toString())
            }

        })
    }

    override fun onCleared() {
        super.onCleared()
    }
}