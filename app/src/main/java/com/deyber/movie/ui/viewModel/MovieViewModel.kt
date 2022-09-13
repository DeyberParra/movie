package com.deyber.movie.ui.viewModel

import androidx.lifecycle.*
import com.deyber.movie.core.Resouce.Resource
import com.deyber.movie.core.Resouce.TYPEERROR
import com.deyber.movie.domain.TypeMoviesUseCase
import com.deyber.movie.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieUseCase: TypeMoviesUseCase):ViewModel() {

    fun popularMovie()= movieUseCase.getPopularMovie().asLiveData()
    fun topRatedMovie()= movieUseCase.getTopRatedMovie().asLiveData()
    fun comingMovie()= movieUseCase.getComingMovie().asLiveData()

}