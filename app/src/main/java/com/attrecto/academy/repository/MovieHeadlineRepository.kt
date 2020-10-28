package com.attrecto.academy.repository

import com.attrecto.academy.model.MovieHeadline

class MovieHeadlineRepository(private val movieHeadlines: List<MovieHeadline> = emptyList()) {

    fun search(title: String): List<MovieHeadline> {
        return movieHeadlines.filter { it.name.contains(title) }
    }
}

