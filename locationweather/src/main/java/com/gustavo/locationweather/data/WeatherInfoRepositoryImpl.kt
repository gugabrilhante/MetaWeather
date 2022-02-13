package com.gustavo.locationweather.data

import com.gustavo.core.presentation.contracts.data.ApiInfoDataSource
import com.gustavo.core.presentation.contracts.domain.LocationWeatherDataSource
import com.gustavo.core.presentation.contracts.domain.WeatherInfoRepository
import com.gustavo.core.presentation.contracts.entity.ApiResult
import com.gustavo.core.presentation.contracts.entity.WeatherInfo

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

class WeatherInfoRepositoryImpl(
    private val locationWeatherDataSource: LocationWeatherDataSource,
    private val apiInfoDataSource: ApiInfoDataSource,
    private val mapper: WeatherInfoMapper = WeatherInfoMapper()
) : WeatherInfoRepository {
    override suspend fun getWeatherInfo(): ApiResult<WeatherInfo> {
        val locationWeather = locationWeatherDataSource.getLocationWeather(WeatherConstants.LOCATION_ID)
        return mapper.fromGsonToWeatherInfo(locationWeather, apiInfoDataSource.getBaseUrl())
    }
}