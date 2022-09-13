package com.deyber.movie.data.repository

import com.deyber.movie.data.network.model.MovieModel
import com.deyber.movie.data.network.model.UserMovieRatedModel
import com.deyber.movie.data.network.model.UserModel

interface NetworkDataSource {

    suspend fun getUser(): UserModel?
    suspend fun getUserRated(): UserMovieRatedModel?

    suspend fun getPopularMovie():MovieModel?
    suspend fun getTopRatedMovie():MovieModel?
    suspend fun getUpComingMovie():MovieModel?


}