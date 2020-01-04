package com.example.modernpractice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modernpractice.R
import com.example.modernpractice.data.Post

class PostAdapter():RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private var list:List<Post> = ArrayList<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        // create a view from my xml
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.feed_list, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setPosts(post:List<Post>){
        this.list = post
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        holder.bindViews(list[position])

    }

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        var postImage = itemView.findViewById(R.id.listFeedPostImageId) as ImageView
        var postTitle = itemView.findViewById(R.id.listFeedTitleId) as TextView
        var postDescription = itemView.findViewById(R.id.listFeedDescriptionId)as TextView


        fun bindViews(post:Post){
            postImage.setImageResource(R.drawable.post1) // not complete
            postTitle.text = post.title
            postDescription.text = post.description
        }
    }
}