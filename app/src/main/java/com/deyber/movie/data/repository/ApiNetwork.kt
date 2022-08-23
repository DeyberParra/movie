package com.deyber.movie.data.repository

import com.deyber.movie.data.model.User
import com.deyber.movie.data.network.MovieClient
import com.deyber.movie.data.network.request.LogRequest
import com.deyber.movie.data.network.response.SessionResponse
import com.deyber.movie.data.network.response.TokenBody
import com.deyber.movie.data.network.response.TokenResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class ApiNetwork @Inject constructor(val api:MovieClient){

    suspend fun getToken():TokenResponse?{

        return  withContext(Dispatchers.IO){
            val response= api.getToken()
            response.body()
        }
    }

    suspend fun validateToken( login: LogRequest):TokenResponse?{
        return withContext(Dispatchers.IO){
            val response = api.validateToken(login)
            response.body()
        }

    }
    suspend fun getSession(token:TokenBody):SessionResponse?{
        return withContext(Dispatchers.IO){
            val response = api.getSesion(token)
            response.body()
        }
    }

    suspend fun getUser(): User?{
        return withContext(Dispatchers.IO){
            val response = api.getUser()
            response.body()
        }
    }
}