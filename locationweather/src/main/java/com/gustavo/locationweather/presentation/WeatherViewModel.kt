package com.gustavo.locationweather.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gustavo.core.presentation.contracts.domain.WeatherInfoFacade
import com.gustavo.core.presentation.presentation.BaseViewModel
import com.gustavo.locationweather.domain.WeatherFacade
import com.gustavo.core.presentation.contracts.entity.ApiResult
import com.gustavo.core.presentation.contracts.entity.WeatherInfo
import kotlinx.coroutines.launch

/**
 * Created by Gustavo Brilhante on 01/12/21
 */
sealed class WeatherScreenState {
    object Loading : WeatherScreenState()
    class Finished(val result: ApiResult<WeatherInfo>) : WeatherScreenState()
}

class WeatherViewModel(
    private val weatherFacade: WeatherInfoFacade
) : BaseViewModel() {

    private val _screenState = MutableLiveData<WeatherScreenState>()
    val screenState: LiveData<WeatherScreenState> = _screenState

    fun onViewResumed() {
        viewModelScope.launch {
            _screenState.postValue(WeatherScreenState.Loading)
            val result = weatherFacade.getWeatherInfo()
            log(result)
            _screenState.postValue(WeatherScreenState.Finished(result))
        }
    }

    private fun log(result: ApiResult<WeatherInfo>) {
        if (result is ApiResult.Success) Log.d("viewModel", "url:${result.data!!.imageUrl}")
    }

}