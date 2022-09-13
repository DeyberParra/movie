package com.deyber.movie.data.room.model.converters

import androidx.room.TypeConverter
import com.deyber.movie.data.room.model.ResultsMovieEntity
import com.google.gson.Gson

class ResultMovieConverter {

    private val gson: Gson = Gson()
    @TypeConverter
    fun toString(value:List<ResultsMovieEntity>?):String?{
        return value?.let{
            gson.toJson(value)
        }
    }
    @TypeConverter
    fun fromString(value:String?):List<ResultsMovieEntity>?{
        return value?.let{
            gson.fromJson(value, Array<ResultsMovieEntity>::class.java).asList()
        }
    }
}