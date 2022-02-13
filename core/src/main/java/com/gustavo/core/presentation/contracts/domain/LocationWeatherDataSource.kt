package com.gustavo.core.presentation.contracts.domain

import com.gustavo.core.presentation.contracts.entity.ApiResult
import com.gustavo.core.presentation.contracts.entity.LocationWeather


/**
 * Created by Gustavo Brilhante on 01/12/21
 */

interface LocationWeatherDataSource {
    suspend fun getLocationWeather(locationId: Int): ApiResult<LocationWeather>
}