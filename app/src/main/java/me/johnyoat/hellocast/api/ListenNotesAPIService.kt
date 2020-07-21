package me.johnyoat.hellocast.api

import me.johnyoat.hellocast.data.episodedata.Episode
import me.johnyoat.hellocast.data.podcastdata.PodCastResponse
import me.johnyoat.hellocast.data.podcastdata.PodcastCuratedResponse
import me.johnyoat.hellocast.utils.Constants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

public interface ListenNotesAPIService {
    @GET("best_podcasts")
    fun getBestPodCast(): Call<PodCastResponse>

    @GET("episodes/{id}")
    fun getEpisode(@Path("id") episodeId:String) : Call<Episode>

    @GET("")
    fun getCuratedList(): Call<PodcastCuratedResponse>

    companion object {
        fun create(): ListenNotesAPIService {
            val client = OkHttpClient.Builder()
                .addInterceptor {
                    it.proceed(
                        it.request().newBuilder()
                            .addHeader("X-ListenAPI-Key", " d6d9e231e6444662ae29d039f36cc7af")
                            .build()
                    )
                }.build()


            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ListenNotesAPIService::class.java)
        }
    }
}