package com.deyber.movie.data.model

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("id")val id:Integer,
                @SerializedName("name")val name:String,
                @SerializedName("username")val username:String)
