package com.gustavo.core.presentation.contracts.domain

import com.gustavo.core.presentation.contracts.entity.ApiResult
import com.gustavo.core.presentation.contracts.entity.WeatherInfo

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

interface WeatherInfoRepository {
    suspend fun getWeatherInfo(): ApiResult<WeatherInfo>
}