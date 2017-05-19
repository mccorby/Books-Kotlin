package com.mccorby.books

import android.app.Application

class App: Application() {

    companion object {
        lateinit var instance: App
            // Delegates need vars but we don't want the setter to be public...
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}

class Configuration(map: Map<String, Any?>) {
    val deviceName: String by map
}