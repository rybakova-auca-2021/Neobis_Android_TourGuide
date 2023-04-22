package com.example.tourguide

data class Place(
    val image: Int,
    val title: String,
    val address: String,
    val workingTime: String,
    val distance: String,
    val price: String,
    val description: String,
    val location: String,
    var isExpandable: Boolean = false
)
