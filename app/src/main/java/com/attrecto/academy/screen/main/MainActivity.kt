package com.attrecto.academy.screen.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.attrecto.academy.R
import com.attrecto.academy.databinding.ActivityMainBinding
import com.attrecto.academy.di.createMainViewModel
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

        viewModel.onMovieHeaderlineClickEvent.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                val i = Intent(Intent.ACTION_VIEW, createSearchUriFor(it))
                this@MainActivity.startActivity(i)
            }
        })
    }

    private fun createSearchUriFor(query : String) = Uri.parse("https://google.com/search")
        .buildUpon()
        .appendQueryParameter("q", query).build()

    private fun createViewModel() = ViewModelProvider(this,
        viewModelFactory {
            createMainViewModel(application)
        }).get(MainViewModel::class.java)
}