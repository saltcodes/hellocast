package me.johnyoat.hellocast.data.podcastdata

import android.util.Log
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

    fun getCuratedPodcastList(): MutableLiveData<List<PodcastCuratedList>> {
        val data = MutableLiveData<List<PodcastCuratedList>>()

        listenNotesAPIService.getCuratedList().enqueue(object : Callback<PodcastCuratedResponse>{

            override fun onResponse(
                call: Call<PodcastCuratedResponse>,
                response: Response<PodcastCuratedResponse>
            ) {
                data.value = response.body()?.curatedLists
            }

            override fun onFailure(call: Call<PodcastCuratedResponse>, t: Throwable) {
                Log.d("error",t.localizedMessage!!)
            }
        })

        return data
    }

    fun getPodCast(podcastId:String): LiveData<Podcast>{
        val data = MutableLiveData<Podcast>()

        listenNotesAPIService.getPodcast(podcastId).enqueue(object : Callback<Podcast>{
            override fun onFailure(call: Call<Podcast>, t: Throwable) {

            }

            override fun onResponse(call: Call<Podcast>, response: Response<Podcast>) {
                data.value = response.body()
            }

        })

        return data
    }

}