package com.deyber.movie.ui.dash.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.deyber.movie.core.Resouce.doFailure
import com.deyber.movie.core.Resouce.doLoading
import com.deyber.movie.core.Resouce.doSuccess
import com.deyber.movie.databinding.FragmentCinemaBinding
import com.deyber.movie.ui.dash.adapter.pagerAdapter.MoviePagerAdapter
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

        val adapter:MoviePagerAdapter = MoviePagerAdapter(childFragmentManager)
        binding.moviePager.adapter = adapter

        binding.tabCinema.setupWithViewPager(binding.moviePager)
    }

}