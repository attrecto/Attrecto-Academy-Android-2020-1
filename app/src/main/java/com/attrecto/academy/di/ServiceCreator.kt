package com.attrecto.academy.di

import com.attrecto.academy.datasource.MovieService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun createRetorfit() = Retrofit.Builder()
    .baseUrl("https://www.omdbapi.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

fun createMovieService(): MovieService {
    val retrofit = createRetorfit()

    return retrofit.create(MovieService::class.java)
}