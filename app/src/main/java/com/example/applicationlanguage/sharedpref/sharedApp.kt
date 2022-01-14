package com.example.applicationlanguage.sharedpref

import android.app.Application

class sharedApp  : Application() {
    companion object {
        lateinit var prefes: prefs
    }
    override fun onCreate() {
        super.onCreate()
        prefes = prefs(applicationContext)
    }
}