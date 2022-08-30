package com.deyber.movie.data.room.netmork

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("id")val id:Integer,
                @SerializedName("name")val name:String,
                @SerializedName("username")val username:String,
                @SerializedName("avatar") val avatar: UserAvatar)
data class UserAvatar(@SerializedName("tmdb") val tmdb:UserTmb)
data class UserTmb(@SerializedName("avatar_path") val avatar_path:String)