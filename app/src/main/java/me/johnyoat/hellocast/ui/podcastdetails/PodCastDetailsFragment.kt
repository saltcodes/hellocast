package me.johnyoat.hellocast.ui.podcastdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialContainerTransform
import me.johnyoat.hellocast.databinding.FragmentPodCastDetailsBinding


class PodCastDetailsFragment : Fragment() {

    private var _binding: FragmentPodCastDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPodCastDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        view.transitionName = arguments?.getString("transitionName")
        return view
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}