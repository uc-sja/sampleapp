package com.mvvm.quotes.viewmodel.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mvvm.quotes.viewmodel.BlankViewModel

class BlankViewModelFactory(private val context: Context?): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BlankViewModel(context!!) as T
    }

}