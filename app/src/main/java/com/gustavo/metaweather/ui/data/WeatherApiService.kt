package com.gustavo.metaweather.ui.data

import com.gustavo.core.presentation.contracts.entity.LocationWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

interface WeatherApiService {
    @GET("location/{locationId}")
    fun getLocationWeather(@Path("locationId") locationId: Int): Call<LocationWeather>
}