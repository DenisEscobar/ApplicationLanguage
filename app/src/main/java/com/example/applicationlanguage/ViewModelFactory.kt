package com.example.applicationlanguage

import androidx.lifecycle.ViewModelProvider

class ViewModelFactory : ViewModelProvider.Factory{

    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModel::class.java)) {
            return ViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}