package me.johnyoat.hellocast.ui.library

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import me.johnyoat.hellocast.data.podcastdata.PodCastRepository
import javax.inject.Inject

@ActivityRetainedScoped
class LibraryViewModel : ViewModel() {
    val podCastRepository = PodCastRepository()
    val bestPodcasts = podCastRepository.getBestPodCast()
}