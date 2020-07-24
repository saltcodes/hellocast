package me.johnyoat.hellocast.data.genredata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import me.johnyoat.hellocast.api.ListenNotesAPIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GenreRepository {
    private val listenNotesAPIService = ListenNotesAPIService.create()

    fun getGenre(): LiveData<List<Genre>>{
        val data = MutableLiveData<List<Genre>>()

        listenNotesAPIService.getGenre().enqueue(object: Callback<GenreResponse>{

            override fun onResponse(call: Call<GenreResponse>, response: Response<GenreResponse>) {
                data.value = response.body()?.genres
            }

            override fun onFailure(call: Call<GenreResponse>, t: Throwable) {

            }

        })
        return data
    }
}