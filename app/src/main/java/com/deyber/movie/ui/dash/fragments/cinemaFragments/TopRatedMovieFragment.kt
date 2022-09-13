package com.deyber.movie.ui.dash.fragments.cinemaFragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.deyber.movie.core.Resouce.doFailure
import com.deyber.movie.core.Resouce.doLoading
import com.deyber.movie.core.Resouce.doSuccess
import com.deyber.movie.databinding.FragmentTopRatedMovieBinding
import com.deyber.movie.domain.model.mapper.toDomain
import com.deyber.movie.ui.dash.adapter.MovieAdapter
import com.deyber.movie.ui.viewModel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopRatedMovieFragment : Fragment() {

    private lateinit var binding: FragmentTopRatedMovieBinding
    private lateinit var adapter: MovieAdapter
    private val vm: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTopRatedMovieBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MovieAdapter()
        binding.rvMovie.adapter = adapter
        binding.rvMovie.layoutManager= GridLayoutManager(context,2)

        vm.topRatedMovie().observe(viewLifecycleOwner){ resource->
            resource.doLoading {
                binding.progress.visibility =View.VISIBLE
            }
            resource.doSuccess {
                binding.progress.visibility =View.GONE
                if(!it.isNullOrEmpty()){
                    adapter.loadData(it.first().toDomain().results)
                }

            }
            resource.doFailure{ msg, throwable, typeError->
                binding.progress.visibility =View.GONE
                Log.e(msg, throwable.toString())
            }
        }
    }


}