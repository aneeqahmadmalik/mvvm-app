package com.aneeque.mvvm_app.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 5)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}