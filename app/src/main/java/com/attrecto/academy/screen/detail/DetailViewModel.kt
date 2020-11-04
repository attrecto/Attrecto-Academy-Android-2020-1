package com.attrecto.academy.screen.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.attrecto.academy.repository.MovieHeadlineRepository

class DetailViewModel(
    application: Application,
    private val imdbId: String
) : AndroidViewModel(application) {

    val title = MutableLiveData(imdbId)
}