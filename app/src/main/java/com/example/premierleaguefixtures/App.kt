package com.example.premierleaguefixtures

import android.app.Application
import com.example.premierleaguefixtures.data.storage.FixturesDatabase

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        FixturesDatabase.createDatabase(applicationContext)

    }
}