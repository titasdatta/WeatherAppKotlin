package com.example.titas.weatherappkotlin.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.titas.weatherappkotlin.ui.adapters.ForecastListAdapter
import com.example.titas.weatherappkotlin.R
import com.example.titas.weatherappkotlin.data.ForecastRequest
import com.example.titas.weatherappkotlin.domain.commands.RequestForecastCommand
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forecastList : RecyclerView = find(R.id.forecast_list);
        forecastList.layoutManager = LinearLayoutManager(this);


        val API_KEY = getResources().getString(R.string.open_weather_map_api_key)
        val url = "http://api.openweathermap.org/data/2.5/forecast/daily?" + "APPID=$API_KEY&q=94043&mode=json&units=metric&cnt=7"
        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result)
            }
        }
    }


}
