package com.rodrigolmti.archtecture.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rodrigolmti.archtecture.R
import com.rodrigolmti.archtecture.database.UserDatabase
import com.rodrigolmti.archtecture.model.User
import kotlinx.android.synthetic.main.activity_create_user.buttonCreate
import kotlinx.android.synthetic.main.activity_create_user.editTextEmail
import kotlinx.android.synthetic.main.activity_create_user.editTextName
import java.util.UUID

class CreateUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)

        buttonCreate.setOnClickListener({
            val user = User(
                    UUID.randomUUID().toString(),
                    editTextName.text.toString(),
                    editTextEmail.text.toString())
            UserDatabase.getInstance(this)!!.userDao().insertUser(user)
            finish()
        })
    }
}
