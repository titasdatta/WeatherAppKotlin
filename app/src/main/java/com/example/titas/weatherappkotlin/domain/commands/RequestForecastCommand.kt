package com.example.titas.weatherappkotlin.domain.commands

import com.example.titas.weatherappkotlin.data.ForecastRequest
import com.example.titas.weatherappkotlin.domain.mappers.ForecastDataMapper
import com.example.titas.weatherappkotlin.domain.model.ForecastList

/**
 * Created by Titas on 7/19/2017.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}