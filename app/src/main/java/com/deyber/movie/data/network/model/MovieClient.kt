package com.deyber.movie.data.network.model
import com.deyber.movie.data.network.request.LogRequest
import com.deyber.movie.data.network.response.SessionResponse
import com.deyber.movie.data.network.response.TokenBody
import com.deyber.movie.data.network.response.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface  MovieClient {

    @GET("authentication/token/new")
    suspend fun getToken(): Response<TokenResponse>

    @POST("authentication/token/validate_with_login")
    suspend fun validateToken(@Body logRequest: LogRequest):Response<TokenResponse>

    @POST("authentication/session/new")
    suspend fun getSesion(
        @Body token: TokenBody
    ):Response<SessionResponse>

    @GET("account")
    suspend fun getUser():Response<UserModel>

    @GET("account/{account_id}/rated/movies")
    suspend fun getrUserRated():Response<UserMovieRatedModel>

    @GET("movie/popular")
    suspend fun getPopularMovies():Response<MovieModel>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies():Response<MovieModel>

    @GET("movie/upcoming")
    suspend fun getUpComingMovies():Response<MovieModel>


}