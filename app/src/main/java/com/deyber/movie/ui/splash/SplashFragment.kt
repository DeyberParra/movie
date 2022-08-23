package com.deyber.movie.ui.splash

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.deyber.movie.R
import com.deyber.movie.core.Resouce.doFailure
import com.deyber.movie.core.Resouce.doLoading
import com.deyber.movie.core.Resouce.doSuccess

import com.deyber.movie.databinding.FragmentSplashBinding
import com.deyber.movie.ui.viewModel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    private val splasViewModel: SplashViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSplashBinding.inflate(layoutInflater)
        return binding.root
        //return inflater.inflate(R.layout.fragment_splash, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        splasViewModel.onCreated()
        splasViewModel.getSession().observe(viewLifecycleOwner, Observer {

            it.doLoading {
                Log.i("Mensaje","Estamos cargando los datos")
            }

            it.doSuccess {
                Log.i("Mensaje"," solicitud success la session es : ${it.session_id}" )
                findNavController().navigate(R.id.dashFragment)
            }

            it.doFailure { mensaje, throwable ->
                Log.i("Mensaje", mensaje?:"Mensaje no identificado")
            }

        })

    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
    }

}