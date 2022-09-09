package com.deyber.movie.core.Resouce

inline fun <reified T> Resource<T>.doLoading(callback: () -> Unit){
    if(this is Resource.Loading<*>){
        callback()
    }
}

inline fun <reified T> Resource<T>.doSuccess(callback:(data:T)->Unit){
    if(this is Resource.Success){
        callback(data)
    }
}

inline fun <reified T> Resource<T>.doFailure(callback: (error:String?, throwable:Throwable?,typeError:TYPEERROR?) -> Unit){
    if(this is Resource.Failure){
        callback(message,throwable,typeError)
    }
}

