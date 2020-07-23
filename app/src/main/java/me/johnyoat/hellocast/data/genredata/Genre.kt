package me.johnyoat.hellocast.data.genredata

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Genre(
    val id: Int,
    val name: String,
    @SerializedName("parent_id")
    val parentId: Int
) : Parcelable

@Parcelize
data class GenreResponse(
    val genres: List<Genre>
):Parcelable