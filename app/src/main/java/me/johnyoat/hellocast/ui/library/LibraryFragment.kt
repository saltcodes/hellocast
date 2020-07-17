package me.johnyoat.hellocast.ui.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.google.android.material.transition.MaterialFadeThrough
import dagger.hilt.android.AndroidEntryPoint
import me.johnyoat.hellocast.data.podcastdata.PodCast
import me.johnyoat.hellocast.databinding.FragmentLibraryBinding

@AndroidEntryPoint
class LibraryFragment : Fragment() {
    //Data Binding
    private var _binding: FragmentLibraryBinding? = null
    private val binding get() = _binding!!

    //view model init
    private val viewModel: LibraryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        enterTransition = MaterialFadeThrough()
        _binding = FragmentLibraryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.bestPodcasts.observe(viewLifecycleOwner) { podcasts ->
            for (podCast:PodCast in podcasts){
                print(podCast.title)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}