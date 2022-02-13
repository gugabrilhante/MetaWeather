package com.gustavo.metaweather.ui.app

import com.gustavo.core.presentation.app.BaseApplication
import com.gustavo.core.presentation.contracts.di.WeatherInjection
import com.gustavo.metaweather.ui.di.DependencyFactoryImpl

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

class MobileApp : BaseApplication() {
    override val weatherInjection: WeatherInjection by lazy {
        DependencyFactoryImpl().create()
    }
}