package com.deyber.movie.data.network.model

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("page")val page:Int,
    @SerializedName("total_pages") val total_pages:Int,
    @SerializedName("total_results") val total_results:Int,
    @SerializedName("results") val results:List<ResultsMovieModel>)

data class ResultsMovieModel(
    @SerializedName("id"                ) var id               : Int?           = null,
    @SerializedName("original_language" ) var originalLanguage : String?        = null,
    @SerializedName("poster_path"       ) var posterPath       : String?        = null,
    @SerializedName("release_date"      ) var releaseDate      : String?        = null,
    @SerializedName("title"             ) var title            : String?        = null,
    @SerializedName("vote_average"      ) var voteAverage      : Double?        = null,
    @SerializedName("vote_count"        ) var voteCount        : Int?           = null
)