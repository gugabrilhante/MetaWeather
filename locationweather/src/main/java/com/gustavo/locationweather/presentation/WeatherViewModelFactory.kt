package com.gustavo.locationweather.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gustavo.core.presentation.app.BaseApplication
import com.gustavo.core.presentation.contracts.di.WeatherInjection

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

class WeatherViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WeatherViewModel(
            weatherInjection.weatherViewModelFacade
        ) as T
    }

    //I know i disrespect LSP principle, It suppose to ideally inject with Dagger2
    private val weatherInjection: WeatherInjection by lazy {
        (context.applicationContext as BaseApplication).weatherInjection
    }

}