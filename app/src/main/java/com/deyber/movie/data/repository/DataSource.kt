package com.deyber.movie.data.repository

import com.deyber.movie.data.room.UserMovieRated
import com.deyber.movie.data.room.netmork.User

interface DataSource {
    suspend fun getUser(): User?

    suspend fun getUserRated():UserMovieRated?

}