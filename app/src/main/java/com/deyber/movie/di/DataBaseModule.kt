package com.deyber.movie.di

import android.content.Context
import androidx.room.Room
import com.deyber.movie.data.room.MovieDataBase
import com.deyber.movie.data.room.model.dao.MovieDao
import com.deyber.movie.data.room.model.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataBaseModule {

    private const val movieDatabase:String ="movie_db"

    @Singleton
    @Provides
    fun provideMovieDataBase(@ApplicationContext context: Context):MovieDataBase{
        return Room.databaseBuilder(context, MovieDataBase::class.java, movieDatabase).build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db:MovieDataBase):UserDao = db.UserDao()

    @Singleton
    @Provides
    fun provideMovieDao(db:MovieDataBase): MovieDao = db.MovieDao()



}