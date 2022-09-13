package com.deyber.movie.ui.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.deyber.movie.domain.UserMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val userMovieUseCase: UserMovieUseCase): ViewModel() {
    fun getProfile() = userMovieUseCase.getUser().asLiveData()
    fun getMovieRated() = userMovieUseCase.getUserRated().asLiveData()
}