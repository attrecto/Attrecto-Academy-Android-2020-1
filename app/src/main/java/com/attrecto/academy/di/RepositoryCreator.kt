package com.attrecto.academy.di

import com.attrecto.academy.repository.MovieHeadlineRepository

fun createMovieHeaderRepository() = MovieHeadlineRepository(createMovieService())