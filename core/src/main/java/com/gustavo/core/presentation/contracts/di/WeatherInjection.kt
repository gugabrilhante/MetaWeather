package com.gustavo.core.presentation.contracts.di

import com.gustavo.core.presentation.contracts.data.ApiInfoDataSource
import com.gustavo.core.presentation.contracts.domain.LocationWeatherDataSource
import com.gustavo.core.presentation.contracts.domain.WeatherInfoFacade
import com.gustavo.core.presentation.contracts.domain.WeatherInfoRepository
import com.gustavo.core.presentation.contracts.entity.WeatherInfo

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

interface WeatherInjection {
    val locationWeatherDataSource: LocationWeatherDataSource
    val weatherInfoRepository: WeatherInfoRepository
    val weatherViewModelFacade: WeatherInfoFacade
    val apiInfoDataSource: ApiInfoDataSource
}