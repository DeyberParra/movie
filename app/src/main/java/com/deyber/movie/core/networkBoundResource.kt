package com.deyber.movie.core
import com.deyber.movie.core.Resouce.Resource
import com.deyber.movie.core.Resouce.TYPEERROR
import kotlinx.coroutines.flow.*

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType) -> Boolean = { true }

) = flow {

    val data = query().first()
     val flow = if (shouldFetch(data))
         {
            emit(Resource.Loading())

            try {
                saveFetchResult(fetch())
                query().map {
                    Resource.Success(it)
                }
            } catch (throwable: Throwable) {

                query().map {
                    if(it!=null){
                        Resource.Success(it)
                    }else{
                        Resource.Failure<ResultType>("Error", null,TYPEERROR.NO_DATA)
                    }
                }
            }
        } else {
            query().map {
                Resource.Success(it)
            }
        }
        emitAll(flow)
}
