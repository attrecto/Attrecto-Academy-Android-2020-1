package com.attrecto.academy.model

import com.google.gson.annotations.SerializedName

data class MovieHeadline(
    @SerializedName("Title")
    val name: String,
    @SerializedName("Year")
    val year: String,
    @SerializedName("imdbID")
    val imdbId: String,
    @SerializedName("Poster")
    val image: String)