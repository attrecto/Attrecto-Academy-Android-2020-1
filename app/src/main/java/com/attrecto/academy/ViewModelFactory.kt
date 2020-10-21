package com.attrecto.academy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Funtion to create viewModelfactories inline whithout having to define a separate class each time
 * Can be copied into other projects
 */
inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
    object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(aClass: Class<T>): T = f() as T
    }