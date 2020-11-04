package com.attrecto.academy.screen.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.attrecto.academy.R
import com.attrecto.academy.databinding.ActivityDetailBinding
import com.attrecto.academy.databinding.ActivityMainBinding
import com.attrecto.academy.di.createDetailViewModel
import com.attrecto.academy.di.createMainViewModel
import com.attrecto.academy.screen.main.MainViewModel
import com.attrecto.academy.utils.viewModelFactory
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        private val ID = "ID"

        fun createLaunchIntent(context: Context, id: String) =
            Intent(context, DetailActivity::class.java).apply {
                putExtra(ID, id)
            }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDetailBinding =
            DataBindingUtil.setContentView(
                this,
                R.layout.activity_detail
            )

        val viewModel = createViewModel(intent.extras?.getString(ID) ?: "EMPTY")

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun createViewModel(imdbId: String) = ViewModelProvider(this,
        viewModelFactory {
            createDetailViewModel(application, imdbId)
        }).get(DetailViewModel::class.java)
}