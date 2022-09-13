package com.deyber.movie.data.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class ResultsMovieEntity(

    @ColumnInfo(name = "id") var id: Int?,
    @ColumnInfo(name = "original_language") var originalLanguage: String?=null,
    @ColumnInfo(name = "poster_path") var posterPath: String?=null,
    @ColumnInfo(name = "release_date") var releaseDate: String?=null,
    @ColumnInfo(name = "title") var title: String?=null,
    @ColumnInfo(name = "vote_average") var voteAverage: Double?=null,
    @ColumnInfo(name = "vote_count") var voteCount: Int? = null
)

@Entity(tableName = "PopularMovie")
data class PopularMovieEntity(
    @PrimaryKey(autoGenerate = true)  var id:Int,
    @ColumnInfo(name="page")  var page: Int,
    @ColumnInfo(name = "total_pages") var total_pages: Int,
    @ColumnInfo(name = "total_results") var total_results: Int,
    @ColumnInfo(name = "results") var results: List<ResultsMovieEntity> =listOf())


@Entity(tableName = "TopRatedMovie")
data class TopRatedMovieEntity(
    @PrimaryKey(autoGenerate = true)  var id:Int,
    @ColumnInfo(name="page")  var page: Int,
    @ColumnInfo(name = "total_pages") var total_pages: Int,
    @ColumnInfo(name = "total_results") var total_results: Int,
    @ColumnInfo(name = "results") var results: List<ResultsMovieEntity> =listOf())

@Entity(tableName = "ComingMovie")
data class ComingMovieEntity(
    @PrimaryKey(autoGenerate = true)  var id:Int,
    @ColumnInfo(name="page")  var page: Int,
    @ColumnInfo(name = "total_pages") var total_pages: Int,
    @ColumnInfo(name = "total_results") var total_results: Int,
    @ColumnInfo(name = "results") var results: List<ResultsMovieEntity> =listOf())