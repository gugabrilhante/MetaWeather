package com.gustavo.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

fun runTesting(f: suspend CoroutineScope.() -> Unit) = runBlocking {
    f()
}