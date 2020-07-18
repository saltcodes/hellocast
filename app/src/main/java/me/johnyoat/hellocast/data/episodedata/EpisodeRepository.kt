package me.johnyoat.hellocast.data.episodedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import me.johnyoat.hellocast.api.ListenNotesAPIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class EpisodeRepository @Inject constructor(private val listenNotesAPIService: ListenNotesAPIService) {

    fun getEpisode(episodeId: String): LiveData<Episode>{
        val data = MutableLiveData<Episode>()

        listenNotesAPIService.getEpisode(episodeId).enqueue(object: Callback<Episode>{
            override fun onResponse(call: Call<Episode>, response: Response<Episode>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<Episode>, t: Throwable) {
            }

        })
        return data
    }
}