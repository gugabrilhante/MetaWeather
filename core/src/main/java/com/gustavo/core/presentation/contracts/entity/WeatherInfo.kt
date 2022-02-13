package com.gustavo.core.presentation.contracts.entity

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

class WeatherInfo(
    val locationName: String,
    val imageUrl: String,
    val temperature: String,
    val weatherStateName: String,
    val lowestTemperature: String,
    val highestTemperature: String
)
