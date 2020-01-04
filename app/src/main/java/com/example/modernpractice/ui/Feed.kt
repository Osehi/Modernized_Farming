package com.example.modernpractice.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modernpractice.R
import com.example.modernpractice.adapter.PostAdapter
import com.example.modernpractice.data.Post
import com.example.modernpractice.viewModel.PostViewModel

/**
 * A simple [Fragment] subclass.
 */
class Feed : Fragment() {



    private lateinit var postViewModel:PostViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.feed, container, false)

        var adapter = PostAdapter()

        var displayList = view.findViewById<RecyclerView>(R.id.recyclerViewFeedId)
        displayList.layoutManager = LinearLayoutManager(this.activity!!.applicationContext)
        displayList.adapter = adapter

        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        postViewModel.getAllPosts().observe(this, object : Observer<List<Post>>{
            override fun onChanged(t: List<Post>?) {
                adapter.setPosts(t!!)
            }

        })

//        val postList= arrayListOf<Post>(
//            Post(null, "Hello", "Wtf"),
//            Post(null, "Hi", "Wttf")
//
//        )




        // the recyclerview
//        var displayList = view.findViewById<RecyclerView>(R.id.recyclerViewFeedId)
        // layout the view in the recyclerView
//        displayList.layoutManager = LinearLayoutManager(this.activity!!.applicationContext)
        // pass the recyclerView to the adapter
//        var adapter = PostAdapter()
//        displayList.adapter = adapter

        return view
    }


}
