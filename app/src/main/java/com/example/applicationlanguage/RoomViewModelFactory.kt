package com.example.applicationlanguage

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.example.applicationlanguage.database.DatabaseDao

class RoomViewModelFactory(
    private val dataSource: DatabaseDao,
    private val application: Application) : ViewModelProvider.Factory
    {
        override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RoomViewModel::class.java)) {
            return RoomViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}