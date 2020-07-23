package me.johnyoat.hellocast.data.podcastdata

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import me.johnyoat.hellocast.data.episodedata.Episode


@Parcelize
data class Podcast(
    val country: String,
    val description: String = "",
    @SerializedName("earliest_pub_date_ms")
    val earliestPubDate: Long,
    val email: String,
    @SerializedName("explicit_content")
    val explicitContent: Boolean,
    val extra: Extra,
    val genre_ids: List<Int>,
    val id: String,
    val image: String,
    @SerializedName("is_claimed")
    val isClaimed: Boolean,
    @SerializedName("itunes_id")
    val itunesId: Int,
    val language: String,
    @SerializedName("latest_pub_date_ms")
    val latestPubDate: Long,
    @SerializedName("listennotes_url")
    val listennotesUrl: String,
    @SerializedName("looking_for")
    val lookingFor: LookingFor,
    val publisher: String,
    val rss: String,
    val thumbnail: String,
    val title: String,
    @SerializedName("total_episodes")
    val totalEpisodes: Int,
    val type: String,
    val website: String,
    val episdoes: List<Episode>
) : Parcelable