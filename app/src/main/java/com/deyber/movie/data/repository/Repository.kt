package com.deyber.movie.data.repository

import androidx.room.withTransaction
import com.deyber.movie.core.networkBoundResource
import com.deyber.movie.data.network.model.UserMovieRatedModel
import com.deyber.movie.data.network.request.LogRequest
import com.deyber.movie.data.network.response.SessionResponse
import com.deyber.movie.data.network.response.TokenBody
import com.deyber.movie.data.network.response.TokenResponse
import com.deyber.movie.data.room.MovieDataBase
import com.deyber.movie.data.room.model.dao.UserDao
import com.deyber.movie.domain.model.User
import com.deyber.movie.domain.model.mapper.toDataBase
import com.deyber.movie.domain.model.mapper.toDomain
import javax.inject.Inject

class Repository @Inject constructor(
    private val api:ApiNetwork, private val userDao: UserDao, private val db: MovieDataBase
):SessionSource{


    override suspend fun getToken(): TokenResponse? {
        return api.getToken()
    }

    override suspend fun validateToken(login: LogRequest): TokenResponse? {
       return api.validateToken(login)
    }

    override suspend fun getSession(token: TokenBody): SessionResponse? {
       return api.getSession(token)
    }

    fun getUser()= networkBoundResource(
        query = {userDao.getUser()},
        fetch = {
            api.getUser()},
        saveFetchResult = {
            db.withTransaction {
                if(it!=null){
                    val a = it.toDomain()
                    val b = a.toDataBase()
                    userDao.deleteAllUser()
                    userDao.newUser(b)
                }

            }
        },
    )

    fun getUserMovieRated() =networkBoundResource(
        query = {userDao.getUserMovieRated()},
        fetch={api.getUserRated()},
        saveFetchResult = {
                if(it!=null){
                    val a = it.toDomain()
                    val b = a.toDataBase()
                    userDao.deleteAllUserMovieRated()
                    userDao.saveUserMoviesRated(b)
                }
            })
}