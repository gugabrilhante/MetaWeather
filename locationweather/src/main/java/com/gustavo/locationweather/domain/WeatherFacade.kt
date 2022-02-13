package com.gustavo.locationweather.domain

import com.gustavo.core.presentation.contracts.domain.WeatherInfoFacade
import com.gustavo.core.presentation.contracts.domain.WeatherInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

class WeatherFacade(
    private val weatherInfoRepository: WeatherInfoRepository
) : WeatherInfoFacade {
    override suspend fun getWeatherInfo() = withContext(Dispatchers.IO) {
        return@withContext weatherInfoRepository.getWeatherInfo()
    }
}