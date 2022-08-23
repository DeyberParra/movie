package com.deyber.movie.data.network.response

import com.google.gson.annotations.SerializedName

data class TokenResponse(@SerializedName("success") val success:Boolean,
                         @SerializedName("expires_at") val expires:String,
                         @SerializedName("request_token") val token:String)

data class TokenBody(@SerializedName("request_token") val token:String)
