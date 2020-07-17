package me.johnyoat.hellocast.ui.library

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import me.johnyoat.hellocast.data.podcastdata.PodCastRepository
import javax.inject.Inject

class LibraryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    podCastRepository: PodCastRepository
) : ViewModel() {

    val bestPodcasts = podCastRepository.getBestPodCast()
}