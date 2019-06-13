package com.miniyo.weatherapp.domain.commands

import com.miniyo.weatherapp.data.ForecastRequest
import com.miniyo.weatherapp.domain.mappers.ForecastDataMapper
import com.miniyo.weatherapp.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: String) :
        Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(
            forecastRequest.execute()
        )
    }
}