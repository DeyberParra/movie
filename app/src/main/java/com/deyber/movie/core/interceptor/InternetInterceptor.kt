package com.deyber.movie.core.interceptor
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject


class InternetInterceptor @Inject constructor(val context: Context):Interceptor, ConnectivityManager.NetworkCallback() {

    private var isOnline = false
    private var connectivityManager:ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    init{
        if(Build.VERSION.SDK_INT>=24){
            connectivityManager.registerDefaultNetworkCallback(this)
        }
    }
    override fun intercept(chain: Interceptor.Chain): Response {
        if(Build.VERSION.SDK_INT<24){
            isOnline = connectivityManager.activeNetworkInfo?.isConnected?:false
        }

        if(isOnline){
            Log.i("internet","Estamos onLine")
            return chain.proceed(chain.request())
        }else{
            Log.i("internet","no tenemos internet")
            throw IOException("WE HAVENT INTERNET")

        }
    }

    override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
        isOnline = networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

}