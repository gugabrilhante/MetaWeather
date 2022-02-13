package com.gustavo.locationweather.di

import com.gustavo.core.presentation.contracts.data.ApiInfoDataSource
import com.gustavo.core.presentation.contracts.di.WeatherInjection
import com.gustavo.core.presentation.contracts.domain.LocationWeatherDataSource
import com.gustavo.locationweather.domain.WeatherFacade
import com.gustavo.core.presentation.contracts.domain.WeatherInfoRepository

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

class WeatherInjectionImpl(
    override val locationWeatherDataSource: LocationWeatherDataSource,
    override val weatherInfoRepository: WeatherInfoRepository,
    override val weatherViewModelFacade: WeatherFacade,
    override val apiInfoDataSource: ApiInfoDataSource
) : WeatherInjection