package com.gustavo.core.presentation.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

open class BaseViewModel: ViewModel() {

    private val scopeJob: Job = SupervisorJob()

    protected var modelViewScope: CoroutineScope = CoroutineScope(Dispatchers.Main + scopeJob)

    override fun onCleared() {
        super.onCleared()
        scopeJob.cancel()
    }
}