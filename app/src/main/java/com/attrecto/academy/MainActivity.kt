package com.attrecto.academy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.attrecto.academy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val TAG = "ALIFECYCLE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = this
        binding.lifecycleOwner = this
    }

    // Megfigyelhető livedata
    var name: MutableLiveData<String> = MutableLiveData("Világ")

    fun showToast(name : String) {
        Toast.makeText(this, getString(R.string.hello_world, name), Toast.LENGTH_SHORT).show()
        this.name.value = ""
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }
}