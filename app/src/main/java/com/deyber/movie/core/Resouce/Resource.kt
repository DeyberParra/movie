package com.deyber.movie.core.Resouce

sealed class Resource<out T> {
    class Loading<out T>: Resource<T>()
    data class Success<out T>(val data:T) : Resource<T>()
    data class Failure<out T>(val message:String?, val throwable:Throwable?, val typeError:TYPEERROR): Resource<T>()
}

enum class TYPEERROR{
    NO_DATA,
    NO_NETWORK,
    NO_DATA_NETWORK,
    ERROR_REQUEST
}