package com.deyber.movie.core.Resouce

sealed class Resource2 <T> (
    val data : T ? =  null,
    val error : Throwable ?= null
){
    class Success<T>(data: T) : Resource2<T>(data)
    class Loading<T>(data: T? = null) : Resource2<T>(data)
    class Error<T>(throwable: Throwable, data: T? = null) : Resource2<T>(data, throwable)
}