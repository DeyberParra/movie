package com.deyber.movie.ui.dash.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deyber.movie.R
import com.deyber.movie._utils.constants.RetrofitConstants
import com.deyber.movie._utils.extensions.typeProfile
import com.deyber.movie.core.Resouce.TYPEERROR
import com.deyber.movie.core.Resouce.doFailure
import com.deyber.movie.core.Resouce.doLoading
import com.deyber.movie.core.Resouce.doSuccess
import com.deyber.movie.databinding.FragmentProfileBinding
import com.deyber.movie.domain.model.mapper.toDomain
import com.deyber.movie.ui.dash.adapter.MovieRatedAdapter
import com.deyber.movie.ui.viewModel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {


    private lateinit var binding: FragmentProfileBinding
    private val profileViewModel: ProfileViewModel by viewModels()

    private lateinit var recycler: RecyclerView
    private lateinit var adapter: MovieRatedAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MovieRatedAdapter()
        recycler = binding.movieRatedRecycler
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(activity,2)

        profileViewModel.getProfile().observe(viewLifecycleOwner){

            it.doLoading {

            }
            it.doFailure { error, throwable, typeError ->

            }
            it.doSuccess {
                val data = it.toDomain()
                binding.userName.text = "@"+ data.username
                binding.userImage.visibility = View.VISIBLE
                data.avatar.tmdb.avatar_path.let {
                    binding.userImage.typeProfile(RetrofitConstants.urlThumb+it)
                }
            }
        }

        profileViewModel.getMovieRated().observe(viewLifecycleOwner){
            it.doLoading {
                binding.progressProfile.visibility = View.VISIBLE
            }
            it.doFailure { error, throwable, typeError ->
                binding.progressProfile.visibility = View.GONE
                if(typeError==TYPEERROR.NO_DATA){
                    findNavController().navigate(R.id.noDataFragment)
                }

            }
            it.doSuccess { data->
                val movieRated = data.first().toDomain()
                binding.progressProfile.visibility = View.GONE
                adapter.loadData(movieRated.results)
            }
        }

    }

}