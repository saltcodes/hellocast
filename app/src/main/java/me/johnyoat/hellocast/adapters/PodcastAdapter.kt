package me.johnyoat.hellocast.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.johnyoat.hellocast.R
import me.johnyoat.hellocast.data.podcastdata.Podcast
import me.johnyoat.hellocast.databinding.ItemPodcastBinding
import me.johnyoat.hellocast.ui.podcastdetails.PodCastDetailsFragment

class PodcastAdapter(private val podcasts: List<Podcast>, private val activity: AppCompatActivity,private val index: Int) :
    RecyclerView.Adapter<PodcastAdapter.PodcastViewHolder>() {

    lateinit var binding: ItemPodcastBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PodcastViewHolder {
        binding = ItemPodcastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PodcastViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return podcasts.size
    }

    override fun onBindViewHolder(holder: PodcastViewHolder, position: Int) {
        holder.setData(podcasts[position])
        holder.itemView.transitionName = "podcast${position}${index}"
        holder.itemView.setOnClickListener{
            val extras = FragmentNavigatorExtras(it to it.transitionName)
            val bundle = Bundle()
            bundle.putString("transitionName",it.transitionName)
            activity.findNavController(R.id.fragmentHost)
                .navigate(R.id.podCastDetailsFragment, bundle, null, extras)

        }
    }

    inner class PodcastViewHolder(binding: ItemPodcastBinding) :
        RecyclerView.ViewHolder(binding.root){
        var transtionName = "podcast"
        lateinit var _podcast: Podcast

        fun setData(podcast: Podcast) {
            _podcast = podcast
            binding.podcastTitle.text = podcast.title
            binding.podcastAuthor.text = podcast.publisher
            Glide.with(activity).load(podcast.thumbnail).into(binding.podcastBanner)
        }
    }
}