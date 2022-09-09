package com.deyber.movie.data.room.model.converters

import androidx.room.TypeConverter
import com.deyber.movie.data.room.model.UserAvatarEntity
import com.google.gson.Gson


class  UserAvatarEntityConverter{

        private val gson:Gson = Gson()

        @TypeConverter
        fun userAvatartoString(value:UserAvatarEntity?):String?{
            return  value?.let{
                gson.toJson(value)
            }

        }

        @TypeConverter
        fun fromString(value:String?):UserAvatarEntity?{
            return value?.let{
                gson.fromJson(value,UserAvatarEntity::class.java)
            }
        }

}
