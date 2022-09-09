package com.deyber.movie.core.interceptor

import com.deyber.movie._utils.constants.RetrofitConstants
import com.deyber.movie.core.sesion.SessionManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class SessionInterceptor @Inject constructor(val sessionManager: SessionManager):Interceptor{

    companion object{
        const val api_key:String = "api_key"
        const val session_id:String ="session_id"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var requestBuilde = chain.request().newBuilder()
        var baseUrl = chain.request().url.newBuilder().addQueryParameter(api_key,RetrofitConstants.apikey).build()

        sessionManager.getSession()?.let {
            baseUrl = chain.request().url.newBuilder()
                .addQueryParameter(api_key, RetrofitConstants.apikey)
                .addQueryParameter(session_id, it)
                .build()
        }

        requestBuilde.url(baseUrl).build()

        return chain.proceed(requestBuilde.build())
    }

}