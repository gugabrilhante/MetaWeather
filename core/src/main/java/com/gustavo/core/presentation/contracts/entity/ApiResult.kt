package com.gustavo.core.presentation.contracts.entity

/**
 * Created by Gustavo Brilhante on 01/12/21
 */

sealed class ApiResult<out R> {
    class Success<out T>(val data: T?) : ApiResult<T>()
    object Error : ApiResult<Nothing>()
}
