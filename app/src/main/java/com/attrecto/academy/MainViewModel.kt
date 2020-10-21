package com.attrecto.academy

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val context : Context
        get() = getApplication()

    // Megfigyelhető livedata
    val name: MutableLiveData<String> = MutableLiveData("https://google.com")

    val openBrowserEvent: MutableLiveData<Event<String>> = MutableLiveData()

    fun showToast(name : String) {
        Toast.makeText(context, context.getString(R.string.hello_world, name), Toast.LENGTH_SHORT).show()
    }

    fun openBrowser(){
        openBrowserEvent.value = Event(name.value ?: "")
    }

}