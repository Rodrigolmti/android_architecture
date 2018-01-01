package com.rodrigolmti.archtecture.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rodrigolmti.archtecture.R.layout
import com.rodrigolmti.archtecture.model.User
import kotlinx.android.synthetic.main.row_user.view.textViewEmail
import kotlinx.android.synthetic.main.row_user.view.textViewId
import kotlinx.android.synthetic.main.row_user.view.textViewName

/**
 * Created by rodrigolmti on 01/01/18.
 * At Framework System
 */
class UserAdapter(private val context: Context, private val list: List<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        return Item(LayoutInflater.from(context).inflate(layout.row_user, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as Item).bindData(list[position])
    }

    class Item(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(item: User) {

            itemView.textViewId.text = item.id
            itemView.textViewName.text = item.name
            itemView.textViewEmail.text = item.email
        }
    }
}