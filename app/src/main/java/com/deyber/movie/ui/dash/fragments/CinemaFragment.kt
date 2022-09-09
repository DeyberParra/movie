package com.deyber.movie.ui.dash.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.deyber.movie.R
import com.deyber.movie.core.Resouce.TYPEERROR
import com.deyber.movie.core.Resouce.doFailure
import com.deyber.movie.core.Resouce.doLoading
import com.deyber.movie.core.Resouce.doSuccess
import com.deyber.movie.databinding.FragmentCinemaBinding
import com.deyber.movie.domain.model.User
import com.deyber.movie.domain.model.UserAvatar
import com.deyber.movie.domain.model.UserTmb
import com.deyber.movie.domain.model.mapper.toDomain
import com.deyber.movie.ui.viewModel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CinemaFragment: Fragment() {

    private lateinit var binding: FragmentCinemaBinding
    private val viewModel:MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        binding= FragmentCinemaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}