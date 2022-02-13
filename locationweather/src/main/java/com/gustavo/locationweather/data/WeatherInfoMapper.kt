package com.gustavo.locationweather.data

import com.gustavo.core.presentation.contracts.entity.ApiResult
import com.gustavo.core.presentation.contracts.entity.LocationWeather
import com.gustavo.core.presentation.contracts.entity.WeatherInfo

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

class WeatherInfoMapper {
    suspend fun fromGsonToWeatherInfo(result: ApiResult<LocationWeather>, baseUrl: String): ApiResult<WeatherInfo> {
        if (result is ApiResult.Success && result.data != null) {
            with(result.data!!) {
                val firstConsolidatedWeather = consolidated_weather.first()
                return ApiResult.Success(
                    WeatherInfo(
                        locationName = title,
                        imageUrl = "{$baseUrl}static/img/weather/${firstConsolidatedWeather.weather_state_abbr}.svg",
                        temperature = firstConsolidatedWeather.the_temp.toInt().toString(),
                        weatherStateName = firstConsolidatedWeather.weather_state_name,
                        lowestTemperature = firstConsolidatedWeather.min_temp.toInt().toString(),
                        highestTemperature = firstConsolidatedWeather.max_temp.toInt().toString()
                    )
                )
            }
        } else {
            return ApiResult.Error
        }
    }
}