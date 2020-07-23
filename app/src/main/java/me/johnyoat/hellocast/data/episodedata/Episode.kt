package me.johnyoat.hellocast.data.episodedata

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import me.johnyoat.hellocast.data.podcastdata.Podcast

@Parcelize
data class Episode(
    val audio: String,
    @SerializedName("audio_length_sec")
    val audio_length_sec: Int,
    val description: String,
    @SerializedName("explicit_content")
    val explicitContent: Boolean ,
    val id: String,
    val image: String,
    val link: String,
    @SerializedName("listennotes_edit_url")
    val listennotesEditUrl: String,
    @SerializedName("listennotes_url")
    val listennotesUrl: String,
    @SerializedName("maybe_audio_invalid")
    val isMaybeAudioInvalid: Boolean,
    @SerializedName("pub_date_ms")
    val pubDate: Long,
    val thumbnail: String,
    val title: String
):Parcelable