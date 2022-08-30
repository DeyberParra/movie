package com.deyber.movie.data.repository

import com.deyber.movie.data.model.UserMovieRated
import com.deyber.movie.data.model.netmork.User

interface DataSource {
    suspend fun getUser(): User?

    suspend fun getUserRated():UserMovieRated?

}