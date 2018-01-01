package com.rodrigolmti.archtecture.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by rodrigolmti on 01/01/18.
 * At Framework System
 */

@Entity()
class User constructor(
        @PrimaryKey
        val id: String,
        val name: String,
        val email: String
)