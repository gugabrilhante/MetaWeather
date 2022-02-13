package com.gustavo.core.presentation.app

import android.app.Application
import com.gustavo.core.presentation.contracts.di.CoreInjection

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

//this application is supposed to be shared between all feature module to make manual dependency injection
abstract class BaseApplication : Application(), CoreInjection {
}