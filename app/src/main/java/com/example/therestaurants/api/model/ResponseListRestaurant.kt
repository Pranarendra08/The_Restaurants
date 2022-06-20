package com.example.therestaurants.api.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseListRestaurant(
    @field:SerializedName("count")
    val count: Int?,

    @field:SerializedName("restaurants")
    val restaurants: List<RestaurantItem>,

    @field:SerializedName("error")
    val error: Boolean?,

    @field:SerializedName("message")
    val message: String?
) : Parcelable
