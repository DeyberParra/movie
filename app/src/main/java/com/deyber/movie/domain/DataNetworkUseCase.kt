package com.deyber.movie.domain

import com.deyber.movie.data.room.UserMovieRated
import com.deyber.movie.data.room.netmork.User
import com.deyber.movie.data.network.request.LogRequest
import com.deyber.movie.data.network.response.SessionResponse
import com.deyber.movie.data.network.response.TokenBody
import com.deyber.movie.data.network.response.TokenResponse
import com.deyber.movie.data.repository.DataSource
import com.deyber.movie.data.repository.Repository
import com.deyber.movie.data.repository.SessionSource
import javax.inject.Inject

class DataNetworkUseCase @Inject constructor(private val repository: Repository): SessionSource,
    DataSource {
    override suspend fun getUser(): User? {
        return repository.getUser()
    }

    override suspend fun getUserRated(): UserMovieRated? {
        return repository.getUserRated()
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