package com.deyber.movie.data.repository


import com.deyber.movie.data.room.UserMovieRated
import com.deyber.movie.data.room.netmork.User
import com.deyber.movie.data.network.MovieClient
import com.deyber.movie.data.network.request.LogRequest
import com.deyber.movie.data.network.response.SessionResponse
import com.deyber.movie.data.network.response.TokenBody
import com.deyber.movie.data.network.response.TokenResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiNetwork @Inject constructor(private val api:MovieClient):SessionSource, DataSource{

    override suspend fun getToken():TokenResponse?{

        return  withContext(Dispatchers.IO){
            val response= api.getToken()
            response.body()
        }
    }

    override suspend fun validateToken( login: LogRequest):TokenResponse?{
        return withContext(Dispatchers.IO){
            val response = api.validateToken(login)
            response.body()
        }

    }
    override suspend fun getSession(token:TokenBody):SessionResponse?{
        return withContext(Dispatchers.IO){
            val response = api.getSesion(token)
            response.body()
        }
    }

    override suspend fun getUser(): User? {
       return withContext(Dispatchers.IO){
           api.getUser().body()
       }
    }

    override suspend fun getUserRated(): UserMovieRated? {
        return withContext(Dispatchers.IO){
            api.getrUserRated().body()
        }
    }

}