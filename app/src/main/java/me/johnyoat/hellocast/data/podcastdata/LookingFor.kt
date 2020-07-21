package me.johnyoat.hellocast.data.podcastdata

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LookingFor(

    @SerializedName("sponsors") val sponsors : Boolean,
    @SerializedName("guests") val guests : Boolean,
    @SerializedName("cohosts") val cohosts : Boolean,
    @SerializedName("cross_promotion") val crossPromotion : Boolean
) : Parcelable