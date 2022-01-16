package com.example.weatherforecast.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.R
import com.example.weatherforecast.model.WeatherResult
import java.text.SimpleDateFormat
import java.util.*

class ItemAdapter (private val dataSet: WeatherResult?) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val tv_date         : TextView
        val tv_temperature  : TextView
        val tv_pressure     : TextView
        val tv_humidity     : TextView
        val tv_description  : TextView

        init {
            tv_date         = view.findViewById(R.id.tv_date)
            tv_temperature  = view.findViewById(R.id.tv_temperature)
            tv_pressure     = view.findViewById(R.id.tv_pressure)
            tv_humidity     = view.findViewById(R.id.tv_humidity)
            tv_description  = view.findViewById(R.id.tv_description)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_weather, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tv_date.text = "Date: " + SimpleDateFormat("E, dd MMM yyyy").format(Date(dataSet!!.list[position].dt * 1000))
        viewHolder.tv_temperature.text = "Average temperature: " + Math.round(dataSet!!.list[position].temp.eve - 273.15) + "°C"
        viewHolder.tv_pressure.text = "Pressure: " + dataSet!!.list[position].pressure
        viewHolder.tv_humidity.text = "Humidity: " + dataSet!!.list[position].humidity + "%"
        viewHolder.tv_description.text = "Description: " + dataSet!!.list[position].weather[0].description
    }

    override fun getItemCount() = dataSet!!.list.size
}