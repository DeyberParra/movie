package com.deyber.movie.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.deyber.movie.data.room.model.UserEntity
import com.deyber.movie.data.room.model.UserMovieRatedEntity
import com.deyber.movie.data.room.model.converters.ResultsMovieRatedEntityConverter
import com.deyber.movie.data.room.model.converters.UserAvatarEntityConverter
import com.deyber.movie.data.room.model.dao.UserDao

@Database(entities = [UserEntity::class, UserMovieRatedEntity::class], version=1, exportSchema = false)
@TypeConverters(UserAvatarEntityConverter::class, ResultsMovieRatedEntityConverter::class)
abstract class MovieDataBase:RoomDatabase() {

    abstract fun MovieDao():UserDao

}