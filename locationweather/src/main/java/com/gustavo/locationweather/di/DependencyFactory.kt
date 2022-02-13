package com.gustavo.locationweather.di

import com.gustavo.core.presentation.contracts.data.ApiInfoDataSource
import com.gustavo.core.presentation.contracts.di.WeatherInjection
import com.gustavo.core.presentation.contracts.domain.LocationWeatherDataSource
import com.gustavo.locationweather.data.MetaWeatherApiInfoDataSource
import com.gustavo.locationweather.data.WeatherInfoRepositoryImpl
import com.gustavo.locationweather.domain.WeatherFacade

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

abstract class DependencyFactory {

    abstract val locationWeatherDataSource: LocationWeatherDataSource

    abstract fun create(): WeatherInjection

}