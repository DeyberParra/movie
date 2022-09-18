package com.deyber.movie.ui.viewModel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import com.deyber.movie.core.Resouce.Resource
import com.deyber.movie.core.Resouce.TYPEERROR
import com.deyber.movie.data.firebase.FirebaseRepository
import com.deyber.movie.data.firebase.LocationLiveData
import com.deyber.movie.data.firebase.model.LocationModel
import com.deyber.movie.data.firebase.model.MapModel
import com.google.firebase.firestore.GeoPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(private val repository: FirebaseRepository, private val locationLiveData: LocationLiveData):ViewModel() {

    fun getLocationData()=locationLiveData

    val flowLocation = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            repository.getFlowLocation().collect(){
                emit(it)
            }
        }catch (e:Exception){
            emit(Resource.Failure("error", e, TYPEERROR.ERROR_REQUEST))
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun saveLocation(location:LocationModel) {
        viewModelScope.launch {
            val dateNow: LocalDateTime? = LocalDateTime.now()
            repository.createLocation(MapModel(dateNow.toString(), GeoPoint(location.latitude, location.longitude)))
        }
    }



}


