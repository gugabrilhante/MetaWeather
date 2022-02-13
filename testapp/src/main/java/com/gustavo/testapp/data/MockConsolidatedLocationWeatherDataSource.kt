package com.gustavo.testapp.data

import com.google.gson.Gson
import com.gustavo.core.presentation.contracts.domain.LocationWeatherDataSource
import com.gustavo.core.presentation.contracts.entity.ApiResult
import com.gustavo.core.presentation.contracts.entity.LocationWeather

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

class MockConsolidatedLocationWeatherDataSource : LocationWeatherDataSource {

    private val locationWeatherStr = "{\"consolidated_weather\":[{\"id\":6025362954780672,\"weather_state_name\":\"Heavy Rain\",\"weather_state_abbr\":\"hr\",\"wind_direction_compass\":\"WNW\",\"created\":\"2022-02-12T19:16:22.552579Z\",\"applicable_date\":\"2022-02-12\",\"min_temp\":-12.010000000000002,\"max_temp\":2.4450000000000003,\"the_temp\":-4.43,\"wind_speed\":11.60227257701954,\"wind_direction\":302.669342274029,\"air_pressure\":1018.0,\"humidity\":67,\"visibility\":13.923996361250296,\"predictability\":77},{\"id\":5055709025665024,\"weather_state_name\":\"Heavy Cloud\",\"weather_state_abbr\":\"hc\",\"wind_direction_compass\":\"N\",\"created\":\"2022-02-12T19:16:24.994939Z\",\"applicable_date\":\"2022-02-13\",\"min_temp\":-14.29,\"max_temp\":-9.79,\"the_temp\":-10.33,\"wind_speed\":5.455076284782205,\"wind_direction\":6.499999999999999,\"air_pressure\":1027.0,\"humidity\":61,\"visibility\":15.980424321959754,\"predictability\":71},{\"id\":5618658979086336,\"weather_state_name\":\"Light Cloud\",\"weather_state_abbr\":\"lc\",\"wind_direction_compass\":\"WNW\",\"created\":\"2022-02-12T19:16:27.980617Z\",\"applicable_date\":\"2022-02-14\",\"min_temp\":-15.0,\"max_temp\":-7.365,\"the_temp\":-8.37,\"wind_speed\":5.998526180407752,\"wind_direction\":288.5263338600489,\"air_pressure\":1026.5,\"humidity\":57,\"visibility\":16.38680108168297,\"predictability\":70},{\"id\":6441646787919872,\"weather_state_name\":\"Heavy Cloud\",\"weather_state_abbr\":\"hc\",\"wind_direction_compass\":\"W\",\"created\":\"2022-02-12T19:16:30.951019Z\",\"applicable_date\":\"2022-02-15\",\"min_temp\":-8.780000000000001,\"max_temp\":-4.115,\"the_temp\":-4.045,\"wind_speed\":6.712246522829344,\"wind_direction\":259.1816173139935,\"air_pressure\":1035.0,\"humidity\":63,\"visibility\":14.498143342877595,\"predictability\":71},{\"id\":5585679233843200,\"weather_state_name\":\"Light Rain\",\"weather_state_abbr\":\"lr\",\"wind_direction_compass\":\"SSW\",\"created\":\"2022-02-12T19:16:34.003895Z\",\"applicable_date\":\"2022-02-16\",\"min_temp\":-3.865,\"max_temp\":6.99,\"the_temp\":6.720000000000001,\"wind_speed\":14.13675414491901,\"wind_direction\":207.81994889729773,\"air_pressure\":1017.0,\"humidity\":66,\"visibility\":14.245555953233119,\"predictability\":75},{\"id\":6563883134222336,\"weather_state_name\":\"Hail\",\"weather_state_abbr\":\"h\",\"wind_direction_compass\":\"WNW\",\"created\":\"2022-02-12T19:16:36.962047Z\",\"applicable_date\":\"2022-02-17\",\"min_temp\":-7.61,\"max_temp\":7.495,\"the_temp\":5.82,\"wind_speed\":10.226321681380735,\"wind_direction\":297.0,\"air_pressure\":996.0,\"humidity\":94,\"visibility\":5.587991131790345,\"predictability\":82}],\"time\":\"2022-02-12T17:07:57.661293-05:00\",\"sun_rise\":\"2022-02-12T07:20:15.129967-05:00\",\"sun_set\":\"2022-02-12T17:43:49.841805-05:00\",\"timezone_name\":\"LMT\",\"parent\":{\"title\":\"Canada\",\"location_type\":\"Country\",\"woeid\":23424775,\"latt_long\":\"56.954681,-98.308968\"},\"sources\":[{\"title\":\"BBC\",\"slug\":\"bbc\",\"url\":\"http://www.bbc.co.uk/weather/\",\"crawl_rate\":360},{\"title\":\"Forecast.io\",\"slug\":\"forecast-io\",\"url\":\"http://forecast.io/\",\"crawl_rate\":480},{\"title\":\"HAMweather\",\"slug\":\"hamweather\",\"url\":\"http://www.hamweather.com/\",\"crawl_rate\":360},{\"title\":\"Met Office\",\"slug\":\"met-office\",\"url\":\"http://www.metoffice.gov.uk/\",\"crawl_rate\":180},{\"title\":\"OpenWeatherMap\",\"slug\":\"openweathermap\",\"url\":\"http://openweathermap.org/\",\"crawl_rate\":360},{\"title\":\"Weather Underground\",\"slug\":\"wunderground\",\"url\":\"https://www.wunderground.com/?apiref=fc30dc3cd224e19b\",\"crawl_rate\":720},{\"title\":\"World Weather Online\",\"slug\":\"world-weather-online\",\"url\":\"http://www.worldweatheronline.com/\",\"crawl_rate\":360}],\"title\":\"Toronto\",\"location_type\":\"City\",\"woeid\":4118,\"latt_long\":\"43.648560,-79.385368\",\"timezone\":\"America/Toronto\"}"

    override suspend fun getLocationWeather(locationId: Int) = ApiResult.Success(Gson().fromJson(locationWeatherStr, LocationWeather::class.java))

}