package com.deyber.movie.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deyber.movie.core.Resouce.Resource
import com.deyber.movie.data.model.UserMovieRated
import com.deyber.movie.data.model.netmork.User
import com.deyber.movie.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    private var userProfile = MutableLiveData<Resource<User>>()
    private var userMovieRated =  MutableLiveData<Resource<UserMovieRated>>()

    fun getUserProfile() = userProfile
    fun getUserMovieRated()= userMovieRated

    fun onCreate(){

        viewModelScope.launch {
            userProfile.postValue(Resource.Loading())
            try{
                val user = async { repository.getUser() }.await()
                if(user!=null){
                    userProfile.postValue(Resource.Success(user))
                }else{
                    userProfile.postValue(Resource.Failure("Error: No hay datos de usuario", null))
                }
            }catch (io:Exception){
                userProfile.postValue(Resource.Failure("Error: Solicitud de obtencion de datos de usuario", io))
            }

            userMovieRated.postValue(Resource.Loading())

            try{
               val movieRated = async { repository.getUserRated()}.await()

                if(movieRated!=null){
                    userMovieRated.postValue(Resource.Success(movieRated))
                }else{
                    userMovieRated.postValue(Resource.Failure("Error no hay data", null))
                }

            }catch (io:Exception){
                userMovieRated.postValue(Resource.Failure("Error:Solicitud de Rated del Usuario", io))
            }
        }
    }

}