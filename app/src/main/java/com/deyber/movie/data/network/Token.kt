package com.deyber.movie.data.network

import com.google.gson.annotations.SerializedName

data class Token(@SerializedName("request_token") val token:String)