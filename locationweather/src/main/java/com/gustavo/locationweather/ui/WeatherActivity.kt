package com.gustavo.locationweather.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.gustavo.core.presentation.contracts.entity.ApiResult
import com.gustavo.core.presentation.contracts.entity.WeatherInfo
import com.gustavo.locationweather.presentation.WeatherScreenState
import com.gustavo.locationweather.presentation.WeatherViewModel
import com.gustavo.locationweather.presentation.WeatherViewModelFactory
import com.gustavo.locationweather.ui.ui.theme.MetaWeatherTheme

class WeatherActivity : ComponentActivity() {

    private lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        setContent {
            MetaWeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    WeatherState(viewModel)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onViewResumed()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(
            this,
            WeatherViewModelFactory(this)
        )[WeatherViewModel::class.java]
    }
}

@Composable
fun WeatherState(viewModel: WeatherViewModel) {
    val state by viewModel.screenState.observeAsState()
    when(state){
        is WeatherScreenState.Finished -> WeatherInfoFetched(result = (state as WeatherScreenState.Finished).result)
        is WeatherScreenState.Loading -> OnLoading()
    }


}

@Composable
fun WeatherInfoFetched(result: ApiResult<WeatherInfo>) {
    when(result){
        is ApiResult.Error -> OnError()
        is ApiResult.Success -> onSuccess(weatherInfo = result.data)
    }
}
@Composable
fun OnLoading(){
    Row(modifier = Modifier.padding(all = 20.dp)) {
        Text(text = "Loading", fontSize = 30.sp)
    }
}

@Composable
fun OnError(){
    Row(modifier = Modifier.padding(all = 20.dp)) {
        Text(text = "Could not fetch weather info", fontSize = 30.sp)
    }
}

@Composable
fun onSuccess(weatherInfo: WeatherInfo?) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Text(text = "${weatherInfo?.locationName}", fontSize = 30.sp)
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),

            ) {
            com.skydoves.landscapist.glide.GlideImage(
                imageModel = weatherInfo?.imageUrl,
                contentScale = ContentScale.Fit,
            )
            Column() {
                Text(text = "${weatherInfo?.temperature}°", fontSize = 30.sp)
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "${weatherInfo?.weatherStateName}", fontSize = 15.sp)
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "L: ${weatherInfo?.lowestTemperature}° H: ${weatherInfo?.highestTemperature}°", fontSize = 20.sp)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    val viewModel = WeatherViewModelFactory().create(WeatherViewModel::class.java)
//    MetaWeatherTheme {
//        weatherState(viewModel)
//    }
//    viewModel.onViewResumed()
}