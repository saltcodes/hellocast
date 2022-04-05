package me.johnyoat.hellocast.ui.episodedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.google.android.material.transition.MaterialSharedAxis
import kotlinx.android.synthetic.main.fragment_episode_details.view.*
import kotlinx.android.synthetic.main.toolbar_layout.view.*
import me.johnyoat.hellocast.data.episodedata.Episode
import me.johnyoat.hellocast.databinding.FragmentEpisodeDetailsBinding
import me.johnyoat.hellocast.ext.toDateString


class EpisodeDetailsFragment : Fragment() {
    private var _binding: FragmentEpisodeDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: EpisodeDetailsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.X,true)
        exitTransition = MaterialSharedAxis(MaterialSharedAxis.X,false)
    }
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
        val podCastTitle = requireArguments().getString("podcastTitle")
        val podCastThumbnail = requireArguments().getString("podCastThumbnail")
        setEpisode(episode,podCastThumbnail,podCastTitle)

        binding.root.toolbarTitle.text = "Episode"

        viewModel.getEpisode(episode.id)
            .observe(viewLifecycleOwner) { episodeData ->
                setEpisode(
                    episodeData,
                    podCastThumbnail,
                    podCastTitle
                )
            }

    }

    private fun setEpisode(episode: Episode?, podCastThumbnail: String?, podCastTitle: String?) {
        binding.episodeTitle.text = episode?.title
        Glide.with(requireContext()).load(podCastThumbnail).into(binding.podcastBanner)
        val description = episode?.description
        binding.podcastTitle.text = podCastTitle
        if (description != null) {
            binding.episodeDescription.text =
                HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_COMPACT)
        }
        binding.podcastTime.podcastTime.text = episode?.pubDate?.toDateString()
    }

}