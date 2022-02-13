package com.gustavo.metaweather.ui.di

import com.gustavo.core.presentation.contracts.data.ApiInfoDataSource
import com.gustavo.core.presentation.contracts.di.WeatherInjection
import com.gustavo.locationweather.data.MetaWeatherApiInfoDataSource
import com.gustavo.metaweather.ui.data.RetrofitLocationWeatherDataSource
import com.gustavo.locationweather.data.WeatherInfoRepositoryImpl
import com.gustavo.core.presentation.contracts.domain.LocationWeatherDataSource
import com.gustavo.locationweather.domain.WeatherFacade
import com.gustavo.core.presentation.contracts.domain.WeatherInfoRepository
import com.gustavo.locationweather.di.DependencyFactory
import com.gustavo.locationweather.di.WeatherInjectionImpl

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

class DependencyFactoryImpl : DependencyFactory() {
    override val locationWeatherDataSource: LocationWeatherDataSource by lazy {
        RetrofitLocationWeatherDataSource()
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