package com.gustavo.core.presentation.contracts.entity

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

class LocationWeather (
    val consolidated_weather : List<ConsolidatedWeather>,
    val time : String,
    val sun_rise : String,
    val sun_set : String,
    val timezone_name : String,
    val title : String,
    val location_type : String,
    val woeid : Int,
    val latt_long : String,
    val timezone : String
)