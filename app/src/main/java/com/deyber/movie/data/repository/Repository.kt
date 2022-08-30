package com.deyber.movie.data.repository

import com.deyber.movie.data.model.UserMovieRated
import com.deyber.movie.data.model.netmork.User
import com.deyber.movie.data.network.request.LogRequest
import com.deyber.movie.data.network.response.SessionResponse
import com.deyber.movie.data.network.response.TokenBody
import com.deyber.movie.data.network.response.TokenResponse
import javax.inject.Inject

class Repository @Inject constructor(private val api:ApiNetwork):SessionSource, DataSource {


    override suspend fun getToken(): TokenResponse? {
        return api.getToken()
    }

    override suspend fun validateToken(login: LogRequest): TokenResponse? {
       return api.validateToken(login)
    }

    override suspend fun getSession(token: TokenBody): SessionResponse? {
       return api.getSession(token)
    }

    override suspend fun getUser(): User? {
        return api.getUser()
    }

    override suspend fun getUserRated(): UserMovieRated? {
        return api.getUserRated()
    }
}