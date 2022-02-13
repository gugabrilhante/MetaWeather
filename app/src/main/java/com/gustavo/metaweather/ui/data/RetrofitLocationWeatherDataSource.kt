package com.gustavo.metaweather.ui.data

import com.gustavo.core.presentation.contracts.domain.LocationWeatherDataSource
import com.gustavo.core.presentation.contracts.entity.ApiResult
import com.gustavo.core.presentation.contracts.entity.LocationWeather
import com.gustavo.locationweather.data.WeatherConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


/**
 * Created by Gustavo Brilhante on 01/12/21
 */

class RetrofitLocationWeatherDataSource : LocationWeatherDataSource {

    private var retrofit = Retrofit.Builder()
        .baseUrl(WeatherConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    override suspend fun getLocationWeather(locationId: Int): ApiResult<LocationWeather> {
        val service = retrofit.create(WeatherApiService::class.java)
        return suspendCoroutine { continuation ->
            service.getLocationWeather(locationId).enqueue(object : Callback<LocationWeather> {
                override fun onResponse(call: Call<LocationWeather>, response: Response<LocationWeather>) {
                    continuation.resume(
                        if (response.isSuccessful) ApiResult.Success(response.body())
                        else ApiResult.Error
                    )
                }

                override fun onFailure(call: Call<LocationWeather>, t: Throwable) {
                    continuation.resume(ApiResult.Error)
                }
            })
        }
    }
}