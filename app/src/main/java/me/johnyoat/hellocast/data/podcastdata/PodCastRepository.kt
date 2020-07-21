package me.johnyoat.hellocast.data.podcastdata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import me.johnyoat.hellocast.api.ListenNotesAPIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PodCastRepository {
    private val listenNotesAPIService = ListenNotesAPIService.create()

    fun getBestPodCast(): LiveData<List<Podcast>> {
        val data = MutableLiveData<List<Podcast>>()

        listenNotesAPIService.getBestPodCast().enqueue(object : Callback<PodCastResponse> {
            override fun onResponse(
                call: Call<PodCastResponse>,
                response: Response<PodCastResponse>
            ) {
                data.value = response.body()?.podcasts
            }
            override fun onFailure(call: Call<PodCastResponse>, t: Throwable) {
            }
        })
        return data
    }

}