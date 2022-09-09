package com.deyber.movie.data.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="User")
data class UserEntity(@PrimaryKey
                      @ColumnInfo(name="id") val id: Int,
                      @ColumnInfo(name ="name") val name:String,
                      @ColumnInfo(name="username") val username:String,
                      @ColumnInfo(name="avatar") val avatar: UserAvatarEntity)
data class UserAvatarEntity( val tmdb: UserTmbEntity)
data class UserTmbEntity(val avatar_path:String)