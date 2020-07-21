package me.johnyoat.hellocast.ui.explore

import androidx.lifecycle.ViewModel
import me.johnyoat.hellocast.data.podcastdata.PodCastRepository

class ExploreViewModel : ViewModel() {
    private val podCastRepository = PodCastRepository()
    val curatedList = podCastRepository.getCuratedPodcastList()
}