package me.johnyoat.hellocast.data.podcastdata

import com.google.gson.annotations.SerializedName

data class LookingFor(

    @SerializedName("sponsors") val sponsors : Boolean,
    @SerializedName("guests") val guests : Boolean,
    @SerializedName("cohosts") val cohosts : Boolean,
    @SerializedName("cross_promotion") val crossPromotion : Boolean
)