package org.ippon.rickandmorty.service.models

sealed class Response<T> {
    class Loading<T> : Response<T>()
    data class Success<T>(val result: T) : Response<T>()
    data class CustomError<T>(val error: Throwable) : Response<T>()
}