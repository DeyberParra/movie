package com.deyber.movie.data.repository

import com.deyber.movie.data.network.model.UserMovieRatedModel
import com.deyber.movie.data.network.model.UserModel

interface NetworkDataSource {

    suspend fun getUser(): UserModel?
    suspend fun getUserRated(): UserMovieRatedModel?

}