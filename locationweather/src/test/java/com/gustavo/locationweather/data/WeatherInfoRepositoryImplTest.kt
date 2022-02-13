package com.gustavo.locationweather.data

import com.gustavo.core.presentation.contracts.data.ApiInfoDataSource
import com.gustavo.core.presentation.contracts.domain.LocationWeatherDataSource
import com.gustavo.core.presentation.contracts.entity.ApiResult
import com.gustavo.core.presentation.contracts.entity.ConsolidatedWeather
import com.gustavo.core.presentation.contracts.entity.LocationWeather
import com.gustavo.core.presentation.contracts.entity.WeatherInfo
import com.gustavo.core.runTesting
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

class WeatherInfoRepositoryImplTest {


    private val locationWeatherDataSource: LocationWeatherDataSource = mock()
    private val apiInfoDataSource: ApiInfoDataSource = mock()

    private val baseUrl = "base_url"
    private val locationId = 1

    @Test
    fun `map location name`() = runTesting {
        val mockLocationInfo = mockLocationInfo()

        whenever(apiInfoDataSource.getBaseUrl()).doReturn(baseUrl)
        whenever(apiInfoDataSource.getDefaultLocationId()).doReturn(locationId)
        whenever(locationWeatherDataSource.getLocationWeather(any())).doReturn(ApiResult.Success(mockLocationInfo))

        val repository = WeatherInfoRepositoryImpl(locationWeatherDataSource, apiInfoDataSource)

        val result = repository.getWeatherInfo()

        assertTrue { result is ApiResult.Success }
        val info = (result as ApiResult.Success<WeatherInfo>).data!!

        assertEquals(mockLocationInfo.title, info.locationName)
    }

    @Test
    fun `map image url`() = runTesting {
        val mockLocationInfo = mockLocationInfo()

        whenever(apiInfoDataSource.getBaseUrl()).doReturn(baseUrl)
        whenever(apiInfoDataSource.getDefaultLocationId()).doReturn(locationId)
        whenever(locationWeatherDataSource.getLocationWeather(any())).doReturn(ApiResult.Success(mockLocationInfo))

        val repository = WeatherInfoRepositoryImpl(locationWeatherDataSource, apiInfoDataSource)

        val result = repository.getWeatherInfo()

        assertTrue { result is ApiResult.Success }
        val info = (result as ApiResult.Success<WeatherInfo>).data!!

        val expectedUrl = "{$baseUrl}static/img/weather/${mockLocationInfo.consolidated_weather[0].weather_state_abbr}.svg"
        assertEquals(expectedUrl, info.imageUrl)

    }

    @Test
    fun `map current, min and max temperature to int`() = runTesting {
        val mockLocationInfo = mockLocationInfo()

        whenever(apiInfoDataSource.getBaseUrl()).doReturn(baseUrl)
        whenever(apiInfoDataSource.getDefaultLocationId()).doReturn(locationId)
        whenever(locationWeatherDataSource.getLocationWeather(any())).doReturn(ApiResult.Success(mockLocationInfo))

        val repository = WeatherInfoRepositoryImpl(locationWeatherDataSource, apiInfoDataSource)

        val result = repository.getWeatherInfo()

        assertTrue { result is ApiResult.Success }
        val info = (result as ApiResult.Success<WeatherInfo>).data!!

        val consolidatedWeather = mockLocationInfo.consolidated_weather[0]

        assertEquals(consolidatedWeather.the_temp.toInt().toString(), info.temperature)
        assertEquals(consolidatedWeather.min_temp.toInt().toString(), info.lowestTemperature)
        assertEquals(consolidatedWeather.max_temp.toInt().toString(), info.highestTemperature)

    }

    @Test
    fun `if result ir error, map to error`() = runTesting {
        val mockLocationInfo = mockLocationInfo()

        whenever(apiInfoDataSource.getBaseUrl()).doReturn(baseUrl)
        whenever(apiInfoDataSource.getDefaultLocationId()).doReturn(locationId)
        whenever(locationWeatherDataSource.getLocationWeather(any())).doReturn(ApiResult.Error)

        val repository = WeatherInfoRepositoryImpl(locationWeatherDataSource, apiInfoDataSource)

        val result = repository.getWeatherInfo()

        assertTrue { result is ApiResult.Error }
    }

    @Test
    fun `if result success data is null, map to error`() = runTesting {
        val mockLocationInfo = mockLocationInfo()

        whenever(apiInfoDataSource.getBaseUrl()).doReturn(baseUrl)
        whenever(apiInfoDataSource.getDefaultLocationId()).doReturn(locationId)
        whenever(locationWeatherDataSource.getLocationWeather(any())).doReturn(ApiResult.Success(null))

        val repository = WeatherInfoRepositoryImpl(locationWeatherDataSource, apiInfoDataSource)

        val result = repository.getWeatherInfo()

        assertTrue { result is ApiResult.Error }
    }

}

fun mockLocationInfo() = LocationWeather(
    consolidated_weather = mockConsolidatedWeather(),
    time = "time",
    sun_rise = "sun_rise",
    sun_set = "sun_set",
    timezone_name = "timezone_name",
    title = "title",
    location_type = "location_type",
    woeid = 1,
    latt_long = "latt_long",
    timezone = "timezone",
)

fun mockConsolidatedWeather() = listOf<ConsolidatedWeather>(
    ConsolidatedWeather(
        id = 1,
        weather_state_name = "weather_state_name",
        weather_state_abbr = "weather_state_abbr",
        wind_direction_compass = "wind_direction_compass",
        created = "created",
        applicable_date = "applicable_date",
        min_temp = 0.0,
        max_temp = 0.0,
        the_temp = 0.0,
        wind_speed = 0.0,
        wind_direction = 0.0,
        air_pressure = 0.0f,
        humidity = 1,
        visibility = 1.1,
        predictability = 2
    )
)