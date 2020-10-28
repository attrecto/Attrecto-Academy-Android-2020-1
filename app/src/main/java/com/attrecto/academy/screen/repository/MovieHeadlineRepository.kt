package com.attrecto.academy.screen.repository

import com.attrecto.academy.screen.domain.MovieHeadline

class MovieHeadlineRepository(private val movieHeadlines: List<MovieHeadline> = emptyList()) {

    fun search(title: String): List<MovieHeadline> {
        return movieHeadlines.filter { it.name.contains(title) }
    }

}