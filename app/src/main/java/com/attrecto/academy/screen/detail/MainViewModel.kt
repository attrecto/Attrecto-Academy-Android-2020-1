package com.attrecto.academy.screen.detail

import android.app.Application
import android.content.Context
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

    val movies: MutableLiveData<String> = MutableLiveData()

    fun onSearch() {
        val pattern = pattern.value ?: ""
        movies.value = movieHeadlineRepository.search(pattern).toString()
    }


}