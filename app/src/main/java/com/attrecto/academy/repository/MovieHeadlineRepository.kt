package com.attrecto.academy.repository

import com.attrecto.academy.datasource.MovieService
import com.attrecto.academy.model.MovieHeadline

class MovieHeadlineRepository(private val service : MovieService) {

    suspend fun search(title: String): List<MovieHeadline> {
        return service.search(title, "cd268ceb").Search ?: emptyList()
    }
}

