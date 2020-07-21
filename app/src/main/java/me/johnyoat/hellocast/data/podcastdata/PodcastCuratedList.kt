package me.johnyoat.hellocast.data.podcastdata

import com.google.gson.annotations.SerializedName

data class PodcastCuratedList(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("podcasts") val podcasts: List<Podcast>,
    @SerializedName("source_url") val sourceUrl: String,
    @SerializedName("description") val description: String,
    @SerializedName("pub_date_ms") val pubDate: Int,
    @SerializedName("source_domain") val sourceDomain: String,
    @SerializedName("listennotes_url") val listenNotesUrl: String
)