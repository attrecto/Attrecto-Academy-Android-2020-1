package com.attrecto.academy.screen.main

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.attrecto.academy.model.MovieHeadline
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

    val showEmpty: MutableLiveData<Boolean> = MutableLiveData(false)

    fun onSearch() {
        val pattern = pattern.value ?: ""
        val result = movieHeadlineRepository.search(pattern)
        handleResult(result)
    }

    private fun handleResult(result: List<MovieHeadline>) {
        showEmpty.value = result.isEmpty()
        movies.value = result.map { it.asViewContent() }
    }

    private fun MovieHeadline.asViewContent() = MovieHeadlineAdapter.ViewContent(name, year, {
        Toast.makeText(context, imdbId, Toast.LENGTH_LONG).show()
    })

}