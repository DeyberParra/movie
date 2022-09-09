package com.deyber.movie.data.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "UserMovieRated")
data class UserMovieRatedEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "results") val results: List<ResultsMovieRatedEntity> = listOf(),
    @ColumnInfo(name = "total_results" ) val totalResults: Int?= null
)
data class ResultsMovieRatedEntity (
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int?= null,
    @ColumnInfo(name = "original_language") val originalLanguage:String? = null,
    @ColumnInfo( name = "poster_path") val posterPath:String? = null,
    @ColumnInfo(name = "release_date") val releaseDate : String? = null,
    @ColumnInfo(name = "title") val title : String? = null,
    @ColumnInfo(name = "vote_average") val voteAverage : Double? = null,
    @ColumnInfo( name="vote_count" ) val voteCount : Int? = null,
    @ColumnInfo(name = "rating") val rating : Int? = null
)