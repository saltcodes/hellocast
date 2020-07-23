package me.johnyoat.hellocast.ui.episodedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import me.johnyoat.hellocast.data.episodedata.Episode
import me.johnyoat.hellocast.databinding.FragmentEpisodeDetailsBinding


class EpisodeDetailsFragment : Fragment() {
    private var _binding: FragmentEpisodeDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: EpisodeDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEpisodeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val episode = requireArguments().getParcelable<Episode>("episode")!!
        setEpisode(episode)

        viewModel.getEpisode(episode.id)
            .observe(viewLifecycleOwner) { episodeData -> setEpisode(episodeData) }

    }

    fun setEpisode(episode: Episode?) {
        binding.episodeTitle.text = episode?.title
        Glide.with(requireContext()).load(episode?.thumbnail).into(binding.podcastBanner)
        binding.episodeDescription.text = episode?.description
    }

}