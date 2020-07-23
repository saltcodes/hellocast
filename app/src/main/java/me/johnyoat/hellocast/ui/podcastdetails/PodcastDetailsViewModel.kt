package me.johnyoat.hellocast.ui.podcastdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import me.johnyoat.hellocast.data.podcastdata.PodCastRepository
import me.johnyoat.hellocast.data.podcastdata.Podcast

class PodcastDetailsViewModel :ViewModel() {
    private val podcastRepository = PodCastRepository()

    fun getPodcast(podcastId:String): LiveData<Podcast>{
        return podcastRepository.getPodCast(podcastId)
    }
}