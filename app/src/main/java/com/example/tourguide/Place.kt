package com.example.tourguide

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
class Place(
    val image: Int,
    val title: String?,
    val address: String?,
    val workingTime: String?,
    val distance: String?,
    val averageCheck: String?,
    val description: String?,
    val additionalInformation: String,
    private val location: String?
) : Parcelable
