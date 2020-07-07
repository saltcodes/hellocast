package me.johnyoat.hellocast.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.google.android.material.transition.MaterialFadeThrough
import me.johnyoat.hellocast.R
import me.johnyoat.hellocast.databinding.FragmentHomeBinding
import me.johnyoat.hellocast.ui.podcastdetails.PodCastDetailsFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        enterTransition = MaterialFadeThrough()
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.albumCard.setOnClickListener {

            val extras = FragmentNavigatorExtras(binding.albumCard to "pod_cast_transition")
            requireActivity().findNavController(R.id.fragmentHost)
                .navigate(R.id.podCastDetailsFragment, null, null, extras)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}