package com.plcoding.cryptocurrencyappyt.data.remote.dto


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Stats(
    @SerializedName("subscribers")
    val subscribers: Int,
    @SerializedName("contributors")
    val contributors: Int,
    @SerializedName("stars")
    val stars: Int,
    @SerializedName("followers")
    val followers: Int
)