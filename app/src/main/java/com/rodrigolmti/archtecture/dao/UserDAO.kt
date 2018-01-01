package com.rodrigolmti.archtecture.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.rodrigolmti.archtecture.model.User

/**
 * Created by rodrigolmti on 01/01/18.
 * At Framework System
 */

@Dao
interface UserDAO {

    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM user")
    fun findAllUser() : List<User>
}