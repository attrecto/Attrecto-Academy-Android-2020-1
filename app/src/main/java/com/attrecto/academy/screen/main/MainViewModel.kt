package com.attrecto.academy.screen.main

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.attrecto.academy.model.MovieHeadline
import com.attrecto.academy.repository.MovieHeadlineRepository
import com.attrecto.academy.utils.Event
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.regex.Pattern

class MainViewModel(
    application: Application,
    val movieHeadlineRepository: MovieHeadlineRepository
) : AndroidViewModel(application) {

    private val context: Context
        get() = getApplication()

    // Megfigyelhető livedata
    val pattern: MutableLiveData<String> = MutableLiveData("last")

    private val nullSafePattern: String
        get() = pattern.value ?: ""

    val movies: MutableLiveData<List<MovieHeadlineAdapter.ViewContent>> = MutableLiveData()

    val showEmpty: MutableLiveData<Boolean> = MutableLiveData(false)

    val error: MutableLiveData<String?> = MutableLiveData()

    val showProgressBar: MutableLiveData<Boolean> = MutableLiveData(false)

    val onMovieHeaderlineClickEvent: MutableLiveData<Event<String>> = MutableLiveData()

    var job: Job? = null

    fun onSearch() {
        job?.cancel()
        job = load(nullSafePattern)
    }

    private fun load(pattern: String): Job {
        return viewModelScope.launch {
            showProgressBar.value = true
            try {
                val result = movieHeadlineRepository.search(pattern)
                handleResult(result)
            }catch (e : Exception){
                handleError(e)
            }finally {
                showProgressBar.value = false
            }
        }
    }

    private fun handleError(exception: Exception){
        error.value = exception.localizedMessage
        showEmpty.value = false
        movies.value = null
    }

    private fun handleResult(result: List<MovieHeadline>) {
        error.value = null
        showEmpty.value = result.isEmpty()
        movies.value = result.map { it.asViewContent() }
    }

    private fun MovieHeadline.asViewContent() = MovieHeadlineAdapter.ViewContent(name, year, {
        onMovieHeaderlineClickEvent.value = Event(this.imdbId)
    })

}