package com.deyber.movie.domain.model


data class Movie(
    val page:Int,
    val total_pages:Int,
    val total_results:Int,
    val results:List<ResultsMovie>)

data class ResultsMovie(
    var id : Int?,
    var originalLanguage : String?,
    var posterPath       : String?,
    var releaseDate      : String?,
    var title            : String?,
    var voteAverage      : Double?,
    var voteCount        : Int?
)