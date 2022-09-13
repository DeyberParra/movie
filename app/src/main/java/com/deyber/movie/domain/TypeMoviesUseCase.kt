package com.deyber.movie.domain

import com.deyber.movie.core.Resouce.Resource
import com.deyber.movie.data.repository.Repository
import com.deyber.movie.data.room.model.ComingMovieEntity
import com.deyber.movie.data.room.model.PopularMovieEntity
import com.deyber.movie.data.room.model.TopRatedMovieEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TypeMoviesUseCase @Inject constructor(private val repository: Repository) {


    fun getPopularMovie():Flow<Resource<List<PopularMovieEntity>>>{
        return repository.getPopularMovie()
    }

    fun getTopRatedMovie():Flow<Resource<List<TopRatedMovieEntity>>>{
        return repository.getTopRatedMovie()
    }
    fun getComingMovie():Flow<Resource<List<ComingMovieEntity>>>{
        return repository.getComingMovie()
    }


}