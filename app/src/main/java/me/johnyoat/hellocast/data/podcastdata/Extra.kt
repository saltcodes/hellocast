package me.johnyoat.hellocast.data.podcastdata

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Extra(
    @SerializedName("twitter_handle") val twitterHandle: String,
    @SerializedName("facebook_handle") val facebookHandle: String,
    @SerializedName("instagram_handle") val instagramHandle: String,
    @SerializedName("wechat_handle") val wechatHandle: String,
    @SerializedName("patreon_handle") val patreonHandle: String,
    @SerializedName("youtube_url") val youtubeUrl: String,
    @SerializedName("linkedin_url") val linkedinUrl: String,
    @SerializedName("spotify_url") val spotifyUrl: String,
    @SerializedName("google_url") val googleUrl: String,
    @SerializedName("url1") val url1: String,
    @SerializedName("url2") val url2: String,
    @SerializedName("url3") val url3: String
) : Parcelable