package com.deyber.movie.ui.dash.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.deyber.movie.databinding.FragmentCinemaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CinemaFragment: Fragment() {


    private lateinit var binding: FragmentCinemaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCinemaBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}