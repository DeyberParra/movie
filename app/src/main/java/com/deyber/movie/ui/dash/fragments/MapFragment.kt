package com.deyber.movie.ui.dash.fragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.deyber.movie.R
import com.deyber.movie._utils.Permission
import com.deyber.movie.core.Resouce.doFailure
import com.deyber.movie.core.Resouce.doLoading
import com.deyber.movie.core.Resouce.doSuccess
import com.deyber.movie.databinding.FragmentMapBinding
import com.deyber.movie.ui.viewModel.MapViewModel
import dagger.hilt.android.AndroidEntryPoint
import pub.devrel.easypermissions.EasyPermissions
import com.deyber.movie._utils.constants.Constants
import com.deyber.movie.data.firebase.model.MapModel
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import pub.devrel.easypermissions.AppSettingsDialog

@AndroidEntryPoint
class MapFragment: Fragment(),EasyPermissions.PermissionCallbacks, OnMapReadyCallback {

    private lateinit var binding: FragmentMapBinding
    private val vm:MapViewModel by viewModels()
    private lateinit var  map:GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMapBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.progress.visibility =View.VISIBLE

        requestPermission()
        createMapFragment()

        vm.flowLocation.observe(viewLifecycleOwner){
            it.doLoading {
                binding.progress.visibility=View.VISIBLE
            }
            it.doSuccess {mapa->
                binding.progress.visibility=View.GONE
                mapa.map {location->
                    createMarker(location)
                }

            }
            it.doFailure { error, throwable, typeError ->
                binding.progress.visibility=View.GONE
                Log.i("mapa", throwable.toString())

            }
        }
        createLocation()
    }

    private fun createLocation(){
        vm.getLocationData().observe(viewLifecycleOwner){
            vm.saveLocation(it)
        }
    }

    private fun createMapFragment(){
        val mapFragament:SupportMapFragment = SupportMapFragment.newInstance()
        parentFragmentManager.beginTransaction().add(R.id.map,mapFragament).commit()
        mapFragament.getMapAsync(this)
    }

    private fun requestPermission(){
        if(Permission.hasLocationPermissions(requireContext())){
            return
        }
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.Q){
            EasyPermissions.requestPermissions(
                this,
                resources.getString(R.string.location_permission_message),
                Constants.REQUEST_CODE_LOCATION_PERMISION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_FINE_LOCATION

            )
        }else{
            EasyPermissions.requestPermissions(
                this,
                resources.getString(R.string.location_permission_message),
                Constants.REQUEST_CODE_LOCATION_PERMISION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )
        }

    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {

    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if(EasyPermissions.somePermissionPermanentlyDenied(this, perms)){
            AppSettingsDialog.Builder(this).build().toString()
        }else{
            requestPermission()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions,grantResults)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map=googleMap
        binding.progress.visibility = View.GONE
    }

    fun createMarker(mapData:MapModel) {
        mapData.location?.let{ geopoin->
            val coordinates = LatLng(geopoin.latitude, geopoin.longitude)
            val marker:MarkerOptions =MarkerOptions().position(coordinates).title(mapData.date)
            map.addMarker(marker)
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates,18f),100,null)
        }

    }
}