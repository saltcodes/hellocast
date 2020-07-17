package me.johnyoat.hellocast.data.podcastdata

data class PodCastResponse(
    val id : Int,
    val name : String,
    val parent_id : String,
    val podcasts : List<PodCast>,
    val total : Int,
    val has_next : Boolean,
    val has_previous : Boolean,
    val page_number : Int,
    val previous_page_number : Int,
    val next_page_number : Int,
    val listennotes_url : String
) {
}