package com.attrecto.academy.screen.main

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.attrecto.academy.repository.MovieHeadlineRepository

class MainViewModel(
    application: Application,
    val movieHeadlineRepository: MovieHeadlineRepository
) : AndroidViewModel(application) {

    private val context: Context
        get() = getApplication()

    // Megfigyelhető livedata
    val pattern: MutableLiveData<String> = MutableLiveData("last")

    val movies: MutableLiveData<List<MovieHeadlineAdapter.ViewContent>> = MutableLiveData()

    fun onSearch() {
        val pattern = pattern.value ?: ""
        movies.value = movieHeadlineRepository.search(pattern).map {
            MovieHeadlineAdapter.ViewContent(it.name, it.year, {
                Toast.makeText(context, it.imdbId, Toast.LENGTH_LONG).show()
            })
        }
    }


}