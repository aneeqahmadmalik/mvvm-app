package com.aneeque.mvvm_app.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aneeque.mvvm_app.db.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE username LIKE :username")
    fun findByUsername(username: String): User

    @Insert
    fun insertUser(vararg user: User)
}