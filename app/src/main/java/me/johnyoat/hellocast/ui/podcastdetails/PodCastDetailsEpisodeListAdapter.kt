package me.johnyoat.hellocast.ui.podcastdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import me.johnyoat.hellocast.R
import me.johnyoat.hellocast.data.episodedata.Episode
import me.johnyoat.hellocast.databinding.ItemPodcastEpisodeBinding


class PodCastDetailsEpisodeListAdapter(
    private val episodes: List<Episode>,
    private val activity: AppCompatActivity,
    private val title: String,
    private val thumbnail: String
) :
    RecyclerView.Adapter<PodCastDetailsEpisodeListAdapter.PodCastDetailsEpisodeViewHolder>() {

    lateinit var binding: ItemPodcastEpisodeBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PodCastDetailsEpisodeViewHolder {
        binding =
            ItemPodcastEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PodCastDetailsEpisodeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return episodes.size
    }

    override fun onBindViewHolder(holder: PodCastDetailsEpisodeViewHolder, position: Int) {
        holder.setData(episodes[position])
        holder.itemView.setOnClickListener {
            val bundle = bundleOf(
                "episode" to episodes[position],
                "podCastThumbnail" to thumbnail,
                "podcastTitle" to title
            )
            activity.findNavController(R.id.fragmentHost)
                .navigate(R.id.episodeDetailsFragment, bundle, null, null)

        }
    }

    inner class PodCastDetailsEpisodeViewHolder(binding: ItemPodcastEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(episode: Episode) {
            binding.episodeTitle.text = episode.title
        }
    }
}