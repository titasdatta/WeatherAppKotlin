package com.example.titas.weatherappkotlin.domain.model


/**
 * Created by Titas on 7/19/2017.
 */
data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>){
    val size: Int
        get() = dailyForecast.size
    operator fun get(position: Int): Forecast = dailyForecast.get(position)
}
data class Forecast(val date: String, val description: String, val high: Int, val low: Int, val iconUrl: String)