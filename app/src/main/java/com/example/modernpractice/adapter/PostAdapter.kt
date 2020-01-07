package com.example.modernpractice.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.modernpractice.R
import com.example.modernpractice.data.Post
import com.example.modernpractice.ui.FeedDirections
import com.example.modernpractice.viewModel.PostViewModel


class PostAdapter(val postViewModel: PostViewModel) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private var list: List<Post> = ArrayList<Post>()
    private var listener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        // create a view from my xml
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.feed_list, parent, false)

        return ViewHolder(view, postViewModel)
    }


    override fun getItemCount(): Int {
        return list.size
    }


    fun setPosts(post: List<Post>) {
        this.list = post
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        holder.bindViews(list[position], position, listener)
    }

    fun getPostAt(position: Int): Post {
        return list.get(position)

    }

    inner class ViewHolder(itemView: View, val postViewModel: PostViewModel) :
        RecyclerView.ViewHolder(itemView) {


        var postImage = itemView.findViewById(R.id.listFeedPostImageId) as ImageView
        var postTitle = itemView.findViewById(R.id.listFeedTitleId) as TextView
        var postDescription = itemView.findViewById(R.id.listFeedDescriptionId) as TextView
        var toDeleletButton = itemView.findViewById<ImageButton>(R.id.listFeedEditOptionId)
        var editPostMade = itemView.findViewById<ImageView>(R.id.editPostId)


        fun bindViews(post: Post, position: Int, listener: View.OnClickListener?) {
            postImage.setImageResource(R.drawable.post1) // not complete
            postTitle.text = post.title
            postDescription.text = post.description
            toDeleletButton.setOnClickListener {
                postViewModel.delete(post)
            }

            editPostMade.setOnClickListener {

            }

            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener?.onClick(it)
                }

            }

        }
    }

    fun setOnItemClickListener(listener: View.OnClickListener) {
        this.listener = listener
    }
}