package com.aneeque.mvvm_app.base

import android.app.Application
import androidx.room.Room
import com.aneeque.mvvm_app.db.AppDatabase

class MyApp : Application() {
    companion object {
        lateinit var roomDB: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        roomDB = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "mvvm-app-database",
        ).allowMainThreadQueries().build()
    }
}