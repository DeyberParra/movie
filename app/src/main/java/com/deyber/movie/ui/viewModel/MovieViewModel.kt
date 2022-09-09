package com.deyber.movie.ui.viewModel

import androidx.lifecycle.*
import com.deyber.movie.domain.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieUseCase: MovieUseCase):ViewModel() {

}