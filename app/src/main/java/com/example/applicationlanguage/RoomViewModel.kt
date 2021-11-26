package com.example.applicationlanguage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.applicationlanguage.database.DatabaseDao

class RoomViewModel(
    val database: DatabaseDao,
    application: Application
) : AndroidViewModel(application) {

}