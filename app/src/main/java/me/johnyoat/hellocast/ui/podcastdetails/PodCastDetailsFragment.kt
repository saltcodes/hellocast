package me.johnyoat.hellocast.ui.podcastdetails

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import com.google.android.material.transition.MaterialSharedAxis
import me.johnyoat.hellocast.data.podcastdata.Podcast
import me.johnyoat.hellocast.databinding.FragmentPodCastDetailsBinding


class PodCastDetailsFragment : Fragment() {

    private var _binding: FragmentPodCastDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PodcastDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.X,true)
        exitTransition = MaterialSharedAxis(MaterialSharedAxis.X,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.episodeRefreshLayout.isRefreshing = true
        val podcast = requireArguments().getParcelable<Podcast>("podcast")
        setUpPodCastDetails(podcast)

        viewModel.getPodcast(podcast!!.id)
            .observe(viewLifecycleOwner) { podcastData -> setUpPodCastDetails(podcastData) }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPodCastDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    @SuppressLint("SetTextI18n")
    private fun setUpPodCastDetails(podcast: Podcast?) {
        binding.podcastTitle.text = podcast?.title
        binding.podcastAuthor.text = podcast?.publisher
        Glide.with(requireContext()).load(podcast?.thumbnail).into(binding.podcastBanner)
        binding.episodeCount.text = "${podcast?.totalEpisodes} Episodes"
        val description = podcast?.description

        if (description != null){
            binding.podcastDescription.text = HtmlCompat.fromHtml(description,HtmlCompat.FROM_HTML_MODE_COMPACT)
        }

        if (podcast?.episodes != null){
            binding.episodeRefreshLayout.isRefreshing = false
            binding.podcastEpisodeList.apply {
                adapter = PodCastDetailsEpisodeListAdapter(podcast.episodes,activity as AppCompatActivity,podcast.title,podcast.thumbnail)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}