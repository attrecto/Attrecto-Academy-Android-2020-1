package com.attrecto.academy.screen.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.attrecto.academy.R
import com.attrecto.academy.di.createMovieHeaderRepository
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
    }

    private fun createViewModel() = ViewModelProvider(this,
        viewModelFactory {
            createMainViewModel(application)
        }).get(MainViewModel::class.java)
}