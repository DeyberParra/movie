package com.deyber.movie.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        splasViewModel.onCreated()
        splasViewModel.getSession().observe(viewLifecycleOwner, Observer {

            it.doLoading {
                binding.progressBar.visibility = View.VISIBLE
            }

            it.doSuccess {
                binding.progressBar.visibility= View.GONE
                findNavController().navigate(R.id.dashFragment)
            }

            it.doFailure { mensaje, throwable,typeError ->
                binding.progressBar.visibility= View.GONE
                findNavController().navigate(R.id.noDataFragment)
            }
        })

    }


}