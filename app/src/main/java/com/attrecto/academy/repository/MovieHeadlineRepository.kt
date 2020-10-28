package com.attrecto.academy.repository

import com.attrecto.academy.model.MovieHeadline
import kotlinx.coroutines.delay

class MovieHeadlineRepository(private val movieHeadlines: List<MovieHeadline> = emptyList()) {

    suspend fun search(title: String): List<MovieHeadline> {
        delay(1000)
        return movieHeadlines.filter { it.name.contains(title) }
    }
}

