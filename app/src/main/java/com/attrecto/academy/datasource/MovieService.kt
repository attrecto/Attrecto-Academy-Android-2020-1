package com.attrecto.academy.datasource

import com.attrecto.academy.model.dto.MovieSearchDto
import retrofit2.http.GET
import retrofit2.http.Query
/*
http://www.omdbapi.com/?s=wars&apikey=cd268ceb
*/
interface MovieService {
    @GET("/")
    suspend fun search(@Query("s") pattern: String, @Query("apiKey") ApiKey: String): MovieSearchDto
}