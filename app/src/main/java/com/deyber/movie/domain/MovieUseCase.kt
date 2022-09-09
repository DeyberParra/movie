package com.deyber.movie.domain

import com.deyber.movie.core.Resouce.Resource
import com.deyber.movie.data.network.request.LogRequest
import com.deyber.movie.data.network.response.SessionResponse
import com.deyber.movie.data.network.response.TokenBody
import com.deyber.movie.data.network.response.TokenResponse
import com.deyber.movie.data.repository.Repository
import com.deyber.movie.data.repository.SessionSource
import com.deyber.movie.data.room.model.UserEntity
import com.deyber.movie.data.room.model.UserMovieRatedEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieUseCase @Inject constructor(private val repository: Repository): SessionSource{

    fun getUser(): Flow<Resource<UserEntity>> {
        return repository.getUser()
    }

    fun getUserRated(): Flow<Resource<List<UserMovieRatedEntity>>> {
        return repository.getUserMovieRated()
    }

    override suspend fun getToken(): TokenResponse? {
        return  repository.getToken()
    }

    override suspend fun validateToken(login: LogRequest): TokenResponse? {
        return repository.validateToken(login)
    }

    override suspend fun getSession(token: TokenBody): SessionResponse? {
        return repository.getSession(token)
    }


}