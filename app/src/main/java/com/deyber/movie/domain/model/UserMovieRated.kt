package com.deyber.movie.domain.model


data class UserMovieRated(
    var results : List<ResultsMovieRated> = listOf(),
    var totalResults : Int? = null
)
data class ResultsMovieRated(
    var id : Int?= null,
    var originalLanguage : String? = null,
    var posterPath : String? = null,
    var releaseDate: String? = null,
    var title: String? = null,
    var voteAverage: Double? = null,
    var voteCount: Int? = null,
    var rating: Int? = null
)
