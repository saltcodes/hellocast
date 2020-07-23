package me.johnyoat.hellocast.ui.episodedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import me.johnyoat.hellocast.data.episodedata.Episode
import me.johnyoat.hellocast.data.episodedata.EpisodeRepository

class EpisodeDetailsViewModel:ViewModel() {
    private val episodeRepository = EpisodeRepository()

    fun getEpisode(episodeId:String): LiveData<Episode>{
        return episodeRepository.getEpisode(episodeId)
    }
}