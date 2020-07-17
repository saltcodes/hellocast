package me.johnyoat.hellocast.data.podcastdata

data class PodCast(
    val id : String,
    val title : String,
    val publisher : String,
    val image : String,
    val thumbnail : String,
    val listennotes_url : String,
    val total_episodes : Int,
    val explicit_content : Boolean,
    val description : String,
    val itunes_id : Int,
    val rss : String,
    val latest_pub_date_ms : Int,
    val earliest_pub_date_ms : Int,
    val language : String,
    val country : String,
    val website : String,
    val is_claimed : Boolean,
    val email : String,
    val type : String,
    val genre_ids : List<Int>
)