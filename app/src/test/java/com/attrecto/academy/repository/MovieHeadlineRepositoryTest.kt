package com.attrecto.academy.repository

import com.attrecto.academy.domain.MovieHeadline
import junit.framework.Assert.assertEquals
import org.junit.Test

class MovieHeadlineRepositoryTest {

    private val movies = listOf(
        MovieHeadline("The last dance", "2020", "tt8420184"),
        MovieHeadline("The big bang theory", "2007", "tt0898266")
    )

    @Test
    fun emptyRepositoryShouldReturnEmptyList() {
        val repository = MovieHeadlineRepository()
        assertEquals(0, repository.search("").size)
    }

    @Test
    fun emptyPatternShouldReturnAllMovies() {
        val repository = MovieHeadlineRepository(movies)
        assertEquals(movies.size, repository.search("").size)
    }

    @Test
    fun patternShouldReturnMathcingMovies() {
        val repository = MovieHeadlineRepository(movies)
        assertEquals(1, repository.search("last").size)
        assertEquals("tt8420184", repository.search("last")[0].imdbId)
    }


}