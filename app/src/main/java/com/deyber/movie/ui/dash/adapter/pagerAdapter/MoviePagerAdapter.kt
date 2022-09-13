package com.deyber.movie.ui.dash.adapter.pagerAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.deyber.movie.ui.dash.fragments.cinemaFragments.ComingMovieFragment
import com.deyber.movie.ui.dash.fragments.cinemaFragments.PopularMovieFragment
import com.deyber.movie.ui.dash.fragments.cinemaFragments.TopRatedMovieFragment


class MoviePagerAdapter(fm:FragmentManager): FragmentStatePagerAdapter(fm) {

    companion object{
        const val options:Int=3
        const val popularMovie="POPULAR MOVIES"
        const val topRatedMovie="TOP RATED MOVIES"
        const val comingMovie="COMING MOVIES!"
    }


    override fun getCount(): Int {
        return options
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return PopularMovieFragment()
            1 -> return TopRatedMovieFragment()
            2 -> return ComingMovieFragment()
            else-> return PopularMovieFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {

        when(position){
            0 -> return popularMovie
            1 -> return topRatedMovie
            2 -> return comingMovie
            else-> return popularMovie
        }
    }
}