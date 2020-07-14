package com.example.recyclerapi.adapters
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerapi.R
import com.example.recyclerapi.models.UserModel
import kotlinx.android.synthetic.main.user_row.view.*

class UsersAdapter (private val users: List<UserModel>) : RecyclerView.Adapter<UsersAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val firstName : TextView = itemView.firstName
        val phoneNumber: TextView = itemView.phoneNumber
        val userEmail: TextView = itemView.userEmail!!
        val streetName : TextView = itemView.streetName
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() : Int = users.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.firstName.text = users[position].name
        holder.phoneNumber.text = users[position].phone
        holder.userEmail.text = users[position].email
        holder.streetName.text = "Adress: ${users[position].address.street} , ${users[position].address.suite}, ${users[position].address.city} "
    }

}