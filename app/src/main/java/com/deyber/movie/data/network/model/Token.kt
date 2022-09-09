package com.deyber.movie.data.network.model

import com.google.gson.annotations.SerializedName

data class Token(@SerializedName("request_token") val token:String)