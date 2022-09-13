package com.deyber.movie.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.deyber.movie.data.room.model.*
import com.deyber.movie.data.room.model.converters.ResultMovieConverter
import com.deyber.movie.data.room.model.converters.ResultsMovieRatedEntityConverter
import com.deyber.movie.data.room.model.converters.UserAvatarEntityConverter
import com.deyber.movie.data.room.model.dao.MovieDao
import com.deyber.movie.data.room.model.dao.UserDao

@Database(entities = [UserEntity::class, UserMovieRatedEntity::class, PopularMovieEntity::class, TopRatedMovieEntity::class, ComingMovieEntity::class], version=1, exportSchema = false)
@TypeConverters(UserAvatarEntityConverter::class, ResultsMovieRatedEntityConverter::class, ResultMovieConverter::class)
abstract class MovieDataBase:RoomDatabase() {

    abstract fun UserDao():UserDao
    abstract fun MovieDao():MovieDao

}