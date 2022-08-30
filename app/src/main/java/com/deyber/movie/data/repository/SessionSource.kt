package com.deyber.movie.data.repository

import com.deyber.movie.data.network.request.LogRequest
import com.deyber.movie.data.network.response.SessionResponse
import com.deyber.movie.data.network.response.TokenBody
import com.deyber.movie.data.network.response.TokenResponse

interface SessionSource {

    suspend fun getToken(): TokenResponse?

    suspend fun validateToken( login: LogRequest): TokenResponse?

    suspend fun getSession(token: TokenBody): SessionResponse?

}