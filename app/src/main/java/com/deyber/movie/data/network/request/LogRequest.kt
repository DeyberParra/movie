package com.deyber.movie.data.network.request

import com.google.gson.annotations.SerializedName

data class LogRequest(@SerializedName("username") val user:String,
                      @SerializedName("password") val pass:String,
                      @SerializedName("request_token") val token:String)