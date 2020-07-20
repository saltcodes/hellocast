package me.johnyoat.hellocast.data.podcastdata

import com.google.gson.annotations.SerializedName


data class PodCastResponse(
    @SerializedName("has_next")
    val hasNext: Boolean,
    @SerializedName("has_previous")
    val hasPrevious: Boolean,
    val id: Int,
    @SerializedName("listennotes_url")
    val listennotesUrl: String,
    val name: String,
    @SerializedName("next_page_number")
    val nextPageNumber: Int,
    @SerializedName("page_number")
    val pageNumber: Int,
    @SerializedName("parent_id")
    val parentId: Any,
    val podcasts: List<Podcast>,
    @SerializedName("previous_page_number")
    val previousPageNumber: Int,
    val total: Int
)
