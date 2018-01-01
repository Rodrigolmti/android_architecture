package com.rodrigolmti.archtecture.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.rodrigolmti.archtecture.R.layout
import com.rodrigolmti.archtecture.database.UserDatabase
import com.rodrigolmti.archtecture.model.User
import com.rodrigolmti.archtecture.view.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_main.buttonAddUser
import kotlinx.android.synthetic.main.activity_main.recyclerView

class MainActivity : AppCompatActivity() {

    private val userList: ArrayList<User> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.hasFixedSize()
        recyclerView.adapter = UserAdapter(this, userList)
        recyclerView.visibility = View.VISIBLE

        buttonAddUser.setOnClickListener({
            startActivity(Intent(MainActivity@this, CreateUserActivity::class.java))
        })
    }

    override fun onResume() {
        super.onResume()
        userList.clear()
        userList.addAll(UserDatabase.getInstance(this)!!.userDao().findAllUser())
        recyclerView.adapter.notifyDataSetChanged()
    }
}
