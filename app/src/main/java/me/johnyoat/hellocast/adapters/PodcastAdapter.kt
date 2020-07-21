package me.johnyoat.hellocast.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.johnyoat.hellocast.data.podcastdata.Podcast
import me.johnyoat.hellocast.databinding.ItemPodcastBinding

class PodcastAdapter(private val podcasts : List<Podcast>,private val activity: AppCompatActivity): RecyclerView.Adapter<PodcastAdapter.PodcastViewHolder>() {

    lateinit var binding: ItemPodcastBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PodcastViewHolder {
        binding = ItemPodcastBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PodcastViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return podcasts.size
    }

    override fun onBindViewHolder(holder: PodcastViewHolder, position: Int) {
        holder.setData(podcasts[position])
    }

    inner class PodcastViewHolder(binding: ItemPodcastBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(podcast: Podcast){
            binding.podcastTitle.text = podcast.title
            binding.podcastAuthor.text = podcast.publisher
            Glide.with(activity).load(podcast.thumbnail).into(binding.podcastBanner)
        }
    }
}