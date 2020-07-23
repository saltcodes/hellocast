package me.johnyoat.hellocast.ui.episodedetails

import androidx.lifecycle.ViewModel
import me.johnyoat.hellocast.data.episodedata.EpisodeRepository

class EpisodeDetailsViewModel:ViewModel() {
    private val episodeReadable = EpisodeRepository()

    val episode = episodeReadable.getEpisode("")
}