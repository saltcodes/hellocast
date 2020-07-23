package me.johnyoat.hellocast.ui.episodedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import me.johnyoat.hellocast.data.episodedata.Episode
import me.johnyoat.hellocast.databinding.FragmentEpisodeDetailsBinding


class EpisodeDetailsFragment : Fragment() {
    private var _binding:FragmentEpisodeDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEpisodeDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun setEpisode(episode:Episode){

    }

}