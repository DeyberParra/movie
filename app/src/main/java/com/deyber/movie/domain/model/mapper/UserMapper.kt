package com.deyber.movie.domain.model.mapper

import com.deyber.movie.data.network.model.*
import com.deyber.movie.data.room.model.*
import com.deyber.movie.domain.model.*



fun UserModel.toDomain() = User(id,name,username,avatar.toDomain())
fun UserAvatarModel.toDomain()= UserAvatar(tmdb.toDomain())
fun UserTmbModel.toDomain()= UserTmb(avatar_path)


fun UserEntity.toDomain() = User(id, name, username, avatar.toDomain())
fun UserAvatarEntity.toDomain() =UserAvatar(tmdb.toDomain())
fun UserTmbEntity.toDomain() = UserTmb(avatar_path)

fun User.toDataBase() = UserEntity(id, name, username,avatar.toDataBase())
fun UserAvatar.toDataBase() =UserAvatarEntity(tmdb.toDataBase())
fun UserTmb.toDataBase() = UserTmbEntity(avatar_path)

fun UserMovieRatedModel.toDomain() = UserMovieRated( results.map{it.toDomain()},totalResults)
fun ResultsMovieRatedModel.toDomain() = ResultsMovieRated(id,originalLanguage,posterPath,releaseDate,title,voteAverage,voteCount, rating)

fun UserMovieRatedEntity.toDomain()= UserMovieRated(results.map { it.toDomain()}, totalResults)
fun ResultsMovieRatedEntity.toDomain()= ResultsMovieRated(id, originalLanguage, posterPath, releaseDate, title, voteAverage,voteCount, rating)

fun UserMovieRated.toDataBase()  = UserMovieRatedEntity(0,results.map { it.toDataBase()},totalResults)
fun ResultsMovieRated.toDataBase()= ResultsMovieRatedEntity(id, originalLanguage, posterPath,releaseDate,title,voteAverage,voteCount,rating)

