package com.deyber.movie.data.network.model

import com.google.gson.annotations.SerializedName

data class UserModel(@SerializedName("id")val id: Int,
                     @SerializedName("name")val name:String,
                     @SerializedName("username")val username:String,
                     @SerializedName("avatar") val avatar: UserAvatarModel
)
data class UserAvatarModel(@SerializedName("tmdb") val tmdb: UserTmbModel)
data class UserTmbModel(@SerializedName("avatar_path") val avatar_path:String)