package com.attrecto.academy.di

import com.attrecto.academy.domain.MovieHeadline
import com.attrecto.academy.repository.MovieHeadlineRepository

fun createMovieHeaderRepository() = MovieHeadlineRepository(
    listOf(
        MovieHeadline("The last dance", "2020", "tt8420184"),
        MovieHeadline("The big bang theory", "2007", "tt0898266")
    )
)