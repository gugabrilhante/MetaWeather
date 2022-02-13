package com.gustavo.testapp.app

import com.gustavo.core.presentation.app.BaseApplication
import com.gustavo.core.presentation.contracts.di.WeatherInjection
import com.gustavo.testapp.di.MockDependencyFactory

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

class TestApplication : BaseApplication() {
    override val weatherInjection: WeatherInjection by lazy {
        MockDependencyFactory().create()
    }
}