package com.deyber.movie.ui.dash
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import com.deyber.movie.R
import com.deyber.movie.databinding.FragmentDashBinding
import com.deyber.movie.ui.dash.fragments.CinemaFragment
import com.deyber.movie.ui.dash.fragments.ImagesFragment
import com.deyber.movie.ui.dash.fragments.MapFragment
import com.deyber.movie.ui.dash.fragments.ProfileFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashFragment : Fragment() {

    private lateinit var binding: FragmentDashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashBinding.inflate(layoutInflater)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configs(savedInstanceState)

        binding.menuNavigationView.setOnItemSelectedListener { option ->

            when (option.itemId) {
                R.id.menu_profile -> navigateFragment(ProfileFragment())
                R.id.menu_cinema -> navigateFragment(CinemaFragment())
                R.id.menu_maps -> navigateFragment(MapFragment())
                R.id.menu_image -> navigateFragment(ImagesFragment())
            }
            true
        }

    }

    private fun navigateFragment(fragment:Fragment?){
        fragment?.let{
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(binding.containerFrameLayout.id, fragment)
            transaction.commit()
        }

    }
    override fun onResume() {
        super.onResume()
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
    }
    
    private fun configs(savedInstanceState:Bundle?){

        if(savedInstanceState==null){
            navigateFragment(ProfileFragment())

        }
        // evitamos que regrese al splash
        requireActivity().onBackPressedDispatcher.addCallback(this) {}
    }

}
