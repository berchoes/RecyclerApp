package com.example.recyclerapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerapi.R
import com.example.recyclerapi.models.PostModel
import kotlinx.android.synthetic.main.post_row.view.*

class PostsAdapter (private val posts : List<PostModel>) : RecyclerView.Adapter<PostsAdapter.ViewHolder>(){
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val postTitle : TextView = itemView.postTitle
        val postBody : TextView = itemView.postBody
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_row , parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postTitle.text = posts[position].title
        holder.postBody.text = posts[position].body
    }
}