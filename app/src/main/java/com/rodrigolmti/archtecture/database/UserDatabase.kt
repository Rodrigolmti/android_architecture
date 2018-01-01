package com.rodrigolmti.archtecture.database

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import android.content.Context
import com.rodrigolmti.archtecture.dao.UserDAO
import com.rodrigolmti.archtecture.model.User

/**
 * Created by rodrigolmti on 01/01/18.
 * At Framework System
 */
@Database(entities = arrayOf(User::class), version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDAO

    companion object {

        private val DATABASE_NAME = "userDatabase"
        private var sInstance: UserDatabase? = null
        private val LOCK = Any()

        fun getInstance(context: Context): UserDatabase? {
            if (sInstance == null) {
                synchronized(LOCK) {
                    sInstance = Room.databaseBuilder(context.applicationContext,
                            UserDatabase::class.java, UserDatabase.DATABASE_NAME).allowMainThreadQueries().build()
                }
            }
            return sInstance
        }
    }
}