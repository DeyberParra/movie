package com.deyber.movie.data.room.model.converters

import androidx.room.TypeConverter
import com.deyber.movie.data.room.model.ResultsMovieRatedEntity

import com.google.gson.Gson

class ResultsMovieRatedEntityConverter {
    private val gson:Gson = Gson()

    @TypeConverter
    fun resultsMovieRatedToString(value: List<ResultsMovieRatedEntity>?):String?{
        return value?.let {
            gson.toJson(value)
        }
    }

    @TypeConverter
    fun fromString(value:String?): List<ResultsMovieRatedEntity>? {
        return value?.let{
            gson.fromJson(value,Array<ResultsMovieRatedEntity>::class.java).asList()
        }
    }
}