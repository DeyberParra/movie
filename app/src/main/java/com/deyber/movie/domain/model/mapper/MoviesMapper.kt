package com.deyber.movie.domain.model.mapper

import com.deyber.movie.data.network.model.MovieModel
import com.deyber.movie.data.network.model.ResultsMovieModel
import com.deyber.movie.data.room.model.ComingMovieEntity
import com.deyber.movie.data.room.model.PopularMovieEntity
import com.deyber.movie.data.room.model.ResultsMovieEntity
import com.deyber.movie.data.room.model.TopRatedMovieEntity
import com.deyber.movie.domain.model.Movie
import com.deyber.movie.domain.model.ResultsMovie


fun MovieModel.toDomain() = Movie(page, total_pages, total_results, results.map { it.toDomain() })
fun ResultsMovieModel.toDomain() =
    ResultsMovie(id, originalLanguage, posterPath, releaseDate, title, voteAverage, voteCount)

fun PopularMovieEntity.toDomain()= Movie(page, total_pages,total_results, results.map { it.toDomain() })
fun ResultsMovieEntity.toDomain()= ResultsMovie(id,originalLanguage,posterPath,releaseDate,title,voteAverage,voteCount)

fun Movie.toPopularMovieEntity()= PopularMovieEntity(0, page, total_pages, total_results, results.map { it.toPopularMovieEntity()})
fun ResultsMovie.toPopularMovieEntity()=ResultsMovieEntity(id, originalLanguage, posterPath,releaseDate,title,voteAverage,voteCount)

fun TopRatedMovieEntity.toDomain()= Movie(page, total_pages,total_results, results.map { it.toDomain() })

fun Movie.toTopRatedEntity()= TopRatedMovieEntity(0, page, total_pages, total_results, results.map { it.toTopRatedEntity()})
fun ResultsMovie.toTopRatedEntity()=ResultsMovieEntity(id, originalLanguage, posterPath,releaseDate,title,voteAverage,voteCount)

fun ComingMovieEntity.toDomain()= Movie(page, total_pages,total_results, results.map { it.toDomain() })


fun Movie.toComingMovieEntity()= ComingMovieEntity(0, page, total_pages, total_results, results.map { it.toComingMovieEntity()})
fun ResultsMovie.toComingMovieEntity()=ResultsMovieEntity(id, originalLanguage, posterPath,releaseDate,title,voteAverage,voteCount)