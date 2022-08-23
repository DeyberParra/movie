package com.deyber.movie.data.network.response

import com.google.gson.annotations.SerializedName

class SessionResponse(@SerializedName("success") val success:Boolean,
                      @SerializedName("session_id") val session_id:String)