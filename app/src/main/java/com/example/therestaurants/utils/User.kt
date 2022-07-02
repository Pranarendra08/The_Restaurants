package com.example.therestaurants.utils

import android.media.Image
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val nama: String = "Pranarendra D.",
    val email: String = "Prendra@gmail.com",
    val ttl: String = "29 Februari 2001"
) : Parcelable
