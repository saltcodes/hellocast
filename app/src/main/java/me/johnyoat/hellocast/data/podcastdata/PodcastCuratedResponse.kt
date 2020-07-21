package me.johnyoat.hellocast.data.podcastdata

import com.google.gson.annotations.SerializedName

data class PodcastCuratedResponse(
    @SerializedName("total") val total : Int,
    @SerializedName("has_next") val hasNext : Boolean,
    @SerializedName("page_number") val pageNumber : Int,
    @SerializedName("has_previous") val hasPrevious : Boolean,
    @SerializedName("curated_lists") val curatedLists : List<PodcastCuratedList>,
    @SerializedName("next_page_number") val nextPageNumber : Int,
    @SerializedName("previous_page_number") val previousPageNumber : Int
)