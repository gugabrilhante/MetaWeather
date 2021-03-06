package com.gustavo.core.presentation.contracts.entity

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

data class ConsolidatedWeather (
    val id : Long,
    val weather_state_name : String,
    val weather_state_abbr : String,
    val wind_direction_compass : String,
    val created : String,
    val applicable_date : String,
    val min_temp : Double,
    val max_temp : Double,
    val the_temp : Double,
    val wind_speed : Double,
    val wind_direction : Double,
    val air_pressure : Float,
    val humidity : Int,
    val visibility : Double,
    val predictability : Int
)