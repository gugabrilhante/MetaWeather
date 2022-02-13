package com.gustavo.testapp.di

import com.gustavo.core.presentation.contracts.data.ApiInfoDataSource
import com.gustavo.core.presentation.contracts.di.WeatherInjection
import com.gustavo.core.presentation.contracts.domain.LocationWeatherDataSource
import com.gustavo.core.presentation.contracts.domain.WeatherInfoRepository
import com.gustavo.locationweather.data.MetaWeatherApiInfoDataSource
import com.gustavo.locationweather.data.WeatherInfoRepositoryImpl
import com.gustavo.locationweather.di.DependencyFactory
import com.gustavo.locationweather.di.WeatherInjectionImpl
import com.gustavo.locationweather.domain.WeatherFacade
import com.gustavo.testapp.data.MockConsolidatedLocationWeatherDataSource

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

class MockDependencyFactory : DependencyFactory() {
    override val locationWeatherDataSource: LocationWeatherDataSource by lazy {
        MockConsolidatedLocationWeatherDataSource()
    }
    private val weatherInfoRepository: WeatherInfoRepository by lazy {
        WeatherInfoRepositoryImpl(locationWeatherDataSource, apiInfoDataSource)
    }

    private val weatherViewModelFacade: WeatherFacade by lazy {
        WeatherFacade(weatherInfoRepository)
    }

    private val apiInfoDataSource: ApiInfoDataSource by lazy {
        MetaWeatherApiInfoDataSource()
    }

    override fun create(): WeatherInjection = WeatherInjectionImpl(
        locationWeatherDataSource,
        weatherInfoRepository,
        weatherViewModelFacade,
        apiInfoDataSource
    )
}