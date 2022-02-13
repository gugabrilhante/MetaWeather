package com.gustavo.locationweather.data

import com.gustavo.core.presentation.contracts.data.ApiInfoDataSource

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

class MetaWeatherApiInfoDataSource : ApiInfoDataSource {
    override suspend fun getBaseUrl(): String = WeatherConstants.BASE_URL
    override suspend fun getDefaultLocationId(): Int = WeatherConstants.LOCATION_ID
}