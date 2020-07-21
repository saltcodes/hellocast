package me.johnyoat.hellocast.ui.explore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import me.johnyoat.hellocast.adapters.PodcastAdapter
import me.johnyoat.hellocast.data.podcastdata.PodcastCuratedList
import me.johnyoat.hellocast.databinding.ItemPodcastGroupBinding

class ExplorePodcastCuratedAdapter(
    private val curatedLists: List<PodcastCuratedList>,
    private val activity: AppCompatActivity
) : RecyclerView.Adapter<ExplorePodcastCuratedAdapter.ExplorePodcastCuratedViewHolder>() {

    private lateinit var binding: ItemPodcastGroupBinding
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExplorePodcastCuratedViewHolder {
        binding = ItemPodcastGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExplorePodcastCuratedViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return curatedLists.size
    }

    override fun onBindViewHolder(holder: ExplorePodcastCuratedViewHolder, position: Int) {
        holder.setData(curatedLists[position])
    }


    inner class ExplorePodcastCuratedViewHolder(binding: ItemPodcastGroupBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(curatedItem: PodcastCuratedList) {
            binding.podcastGroupTitle.text = curatedItem.title
            binding.podcastList.apply {
                adapter = PodcastAdapter(curatedItem.podcasts,activity)
                setRecycledViewPool(recycledViewPool)
                setHasFixedSize(true)
            }
        }
    }
}