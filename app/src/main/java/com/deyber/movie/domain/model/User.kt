package com.deyber.movie.domain.model


data class User(val id: Int, val name:String, val username:String, val avatar: UserAvatar)

data class UserAvatar( val tmdb: UserTmb)
data class UserTmb(val avatar_path:String)

