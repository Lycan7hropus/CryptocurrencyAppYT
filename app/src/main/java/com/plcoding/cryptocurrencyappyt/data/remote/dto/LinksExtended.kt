package com.plcoding.cryptocurrencyappyt.data.remote.dto


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class LinksExtended(
    @SerializedName("url")
    val url: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("stats")
    val stats: Stats
)