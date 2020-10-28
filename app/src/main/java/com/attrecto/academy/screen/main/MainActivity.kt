package com.attrecto.academy.screen.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.attrecto.academy.R
import com.attrecto.academy.di.createMovieHeaderRepository
import com.attrecto.academy.databinding.ActivityMainBinding
import com.attrecto.academy.di.createMainViewModel
import com.attrecto.academy.repository.MovieHeadlineRepository
import com.attrecto.academy.screen.detail.DetailActivity
import com.attrecto.academy.utils.viewModelFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
            )
        val viewModel = createViewModel()

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MovieHeadlineAdapter()
    }

    private fun createViewModel() = ViewModelProvider(this,
        viewModelFactory {
            createMainViewModel(application)
        }).get(MainViewModel::class.java)
}