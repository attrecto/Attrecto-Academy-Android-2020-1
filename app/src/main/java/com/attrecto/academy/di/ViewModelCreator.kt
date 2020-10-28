package com.attrecto.academy.di

import android.app.Application
import com.attrecto.academy.screen.detail.MainViewModel

fun createMainViewModel(application: Application) =
    MainViewModel(application, createMovieHeaderRepository())
