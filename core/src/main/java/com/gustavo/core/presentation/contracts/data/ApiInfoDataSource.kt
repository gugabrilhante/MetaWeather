package com.gustavo.core.presentation.contracts.data

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

interface ApiInfoDataSource {
    suspend fun getBaseUrl(): String
    suspend fun getDefaultLocationId(): Int
}