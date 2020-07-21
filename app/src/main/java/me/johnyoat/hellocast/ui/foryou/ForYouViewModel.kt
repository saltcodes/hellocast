package me.johnyoat.hellocast.ui.foryou

import androidx.lifecycle.ViewModel
import me.johnyoat.hellocast.data.podcastdata.PodCastRepository

class ForYouViewModel : ViewModel() {
    private val podCastRepository = PodCastRepository()
}