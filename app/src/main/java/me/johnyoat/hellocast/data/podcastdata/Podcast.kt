package me.johnyoat.hellocast.data.podcastdata

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import me.johnyoat.hellocast.data.episodedata.Episode


@Parcelize
data class Podcast(
    var country: String? = "",
    var description: String? = "",
    @SerializedName("earliest_pub_date_ms")
    var earliestPubDate: Long?,
    var email: String? = "",
    @SerializedName("explicit_content")
    var explicitContent: Boolean?,
    var extra: Extra?,
    var genre_ids: List<Int>?,
    var id: String? = "",
    var image: String? = "",
    @SerializedName("is_claimed")
    var isClaimed: Boolean?,
    @SerializedName("itunes_id")
    var itunesId: Int? = 0,
    var language: String? = "",
    @SerializedName("latest_pub_date_ms")
    var latestPubDate: Long? = 0L,
    @SerializedName("listennotes_url")
    var listennotesUrl: String? = "",
    @SerializedName("looking_for")
    var lookingFor: LookingFor?,
    var publisher: String? = "",
    var rss: String = "",
    var thumbnail: String? = "",
    var title: String? = "",
    @SerializedName("total_episodes")
    var totalEpisodes: Int = 0,
    var type: String? = "",
    var website: String? = "",
    var episodes: List<Episode>,
) : Parcelable