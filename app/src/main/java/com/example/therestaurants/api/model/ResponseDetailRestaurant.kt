package com.example.therestaurants.api.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseDetailRestaurant(
    @field:SerializedName("restaurant")
    val restaurant: Restaurant? = null,

    @field:SerializedName("error")
    val error: Boolean?,

    @field:SerializedName("message")
    val message: String?
) : Parcelable
