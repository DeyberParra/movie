package com.deyber.movie.data.network.request

import com.google.gson.annotations.SerializedName

data class SessionRequest(@SerializedName("request_token") val token:String)