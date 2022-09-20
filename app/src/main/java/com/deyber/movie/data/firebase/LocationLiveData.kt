package com.deyber.movie.data.firebase

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import androidx.lifecycle.LiveData
import com.deyber.movie.data.firebase.model.LocationModel
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult

import com.google.android.gms.location.LocationServices
import javax.inject.Inject

class LocationLiveData @Inject constructor(val context: Context): LiveData<LocationModel>() {

    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    companion object{
        val locationRequest = LocationRequest.create().apply {
            interval=300000
            fastestInterval=300000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        }
    }


    private val locationCallback = object :LocationCallback(){
        override fun onLocationResult(locationResult: LocationResult) {
            for(location in locationResult.locations){
                setLocation(location)
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun startLocationUpdate(){
        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            null
        )
    }

    private fun setLocation(location:Location){
        value = LocationModel(location.latitude, location.longitude)

    }
    @SuppressLint("MissingPermission")
    override fun onActive() {
        super.onActive()
        fusedLocationClient.lastLocation.addOnSuccessListener {
            location:Location?->
            location?.also {
                setLocation(it)
            }
        }
        startLocationUpdate()
    }

    override fun onInactive() {
        super.onInactive()
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }
}