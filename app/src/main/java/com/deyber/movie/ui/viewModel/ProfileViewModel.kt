package com.deyber.movie.ui.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.deyber.movie.domain.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val movieUseCase: MovieUseCase): ViewModel() {
    fun getProfile() = movieUseCase.getUser().asLiveData()
    fun getMovieRated() = movieUseCase.getUserRated().asLiveData()
}