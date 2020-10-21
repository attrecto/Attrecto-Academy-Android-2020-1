package com.attrecto.academy

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.attrecto.academy.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = createViewModel()

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.openBrowserEvent.observe(this, Observer<Event<String>> {
            it.getContentIfNotHandled()?.let {
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(it)
                startActivity(i)
            }
        })

        viewModel.openDetailEvent.observe(this, Observer<Event<String>> {
            it.getContentIfNotHandled()?.let {
                val i = Intent(this, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.ID, it)
                }
                startActivity(i)
            }
        })
    }

    private fun createViewModel() = ViewModelProvider(this, viewModelFactory {
        MainViewModel(application)
    }).get(MainViewModel::class.java)
}