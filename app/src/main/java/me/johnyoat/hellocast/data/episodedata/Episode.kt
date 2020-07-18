package me.johnyoat.hellocast.data.episodedata

data class Episode(
    val audio: String = "",
    val audio_length_sec: Int = 0,
    val description: String = "",
    val explicit_content: Boolean = false,
    val id: String = "",
    val image: String = "",
    val link: String = "",
    val listennotes_edit_url: String = "",
    val listennotes_url: String = "",
    val maybe_audio_invalid: Boolean = false,
    val pub_date_ms: Long = 0L,
    val thumbnail: String = "",
    val title: String = ""
)