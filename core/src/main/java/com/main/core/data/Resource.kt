package com.main.core.data

import com.main.core.exceptions.ApplicationException

sealed class Resource<T>(
    val data: T? = null,
    val exception: ApplicationException? = null
) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(data: T?, exception: ApplicationException?): Resource<T>(data, exception)
}