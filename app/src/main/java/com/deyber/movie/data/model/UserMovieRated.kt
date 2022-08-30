package com.deyber.movie.data.model

import com.google.gson.annotations.SerializedName


data class UserMovieRated(
    @SerializedName("results"       ) var results      : List<ResultsMovieRated> = listOf(),
    @SerializedName("total_results" ) var totalResults : Int?               = null
)
data class ResultsMovieRated (
    @SerializedName("id"                ) var id               : Int?           = null,
    @SerializedName("original_language" ) var originalLanguage : String?        = null,
    @SerializedName("poster_path"       ) var posterPath       : String?        = null,
    @SerializedName("release_date"      ) var releaseDate      : String?        = null,
    @SerializedName("title"             ) var title            : String?        = null,
    @SerializedName("vote_average"      ) var voteAverage      : Double?        = null,
    @SerializedName("vote_count"        ) var voteCount        : Int?           = null,
    @SerializedName("rating"            ) var rating           : Int?           = null
)