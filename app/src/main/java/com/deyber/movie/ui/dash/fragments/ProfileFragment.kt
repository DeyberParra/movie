package com.deyber.movie.ui.dash.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.deyber.movie._utils.constants.RetrofitConstants
import com.deyber.movie.core.Resouce.doFailure
import com.deyber.movie.core.Resouce.doLoading
import com.deyber.movie.core.Resouce.doSuccess
import com.deyber.movie.databinding.FragmentProfileBinding
import com.deyber.movie.ui.dash.adapter.MovieRatedAdapter
import com.deyber.movie.ui.viewModel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : Fragment() {


    private lateinit var binding: FragmentProfileBinding
    private val profileViewModel: ProfileViewModel by viewModels()

    private lateinit var recycler: RecyclerView
    private lateinit var adapter: MovieRatedAdapter

    @Inject
    lateinit var circularProgressBar: CircularProgressDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileViewModel.onCreate()


        adapter = MovieRatedAdapter()
        recycler = binding.movieRatedRecycler
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(activity,2)


        profileViewModel.getUserProfile().observe(viewLifecycleOwner, Observer{
            it.doLoading {
                binding.progressProfile.visibility = View.VISIBLE
            }
            it.doFailure { error, throwable ->

                Log.i("Mensaje", error?:"Mensaje no identificado")
            }
            it.doSuccess {

                binding.userName.text = "@"+it.username
                binding.userImage.visibility = View.VISIBLE
                it.avatar.tmdb.avatar_path.let {
                    Glide
                        .with(this)
                        .load(RetrofitConstants.urlThumb+it)
                        .centerCrop()
                        .circleCrop()
                        .placeholder(circularProgressBar)
                        .into(binding.userImage)

                }
            }
        })
        profileViewModel.getUserMovieRated().observe(viewLifecycleOwner, Observer{
            it.doLoading {
                Log.i("Mensaje", "cargando calificaciones")
            }
            it.doFailure { error, throwable ->
                binding.progressProfile.visibility = View.GONE
                Log.i("Mensaje", error?:"Mensaje no identificado")
            }
            it.doSuccess {data->
                binding.progressProfile.visibility = View.GONE
                adapter.loadData(data.results)
            }
        })

    }

}