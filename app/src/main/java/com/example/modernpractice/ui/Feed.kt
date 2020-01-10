package com.example.modernpractice.ui


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modernpractice.R
import com.example.modernpractice.adapter.PostAdapter
import com.example.modernpractice.data.Post
import com.example.modernpractice.viewModel.PostViewModel
import kotlinx.android.synthetic.main.feed.*

/**
 * A simple [Fragment] subclass.
 */
class Feed : Fragment() {


    private lateinit var postViewModel: PostViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.feed, container, false)

        // add floatActionButton
        var linkfabButton = view.findViewById(R.id.floatActionButtonId) as ImageButton

        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)

        linkfabButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_feed_to_addPost)
        }


        var adapter = PostAdapter(postViewModel)

        var displayList = view.findViewById<RecyclerView>(R.id.recyclerViewFeedId)
        displayList.layoutManager = LinearLayoutManager(this.activity!!.applicationContext)
        displayList.adapter = adapter




        postViewModel.getAllPosts().observe(this, object : Observer<List<Post>> {
            override fun onChanged(t: List<Post>?) {
                adapter.setPosts(t!!)
            }

        })


        // create operation
        arguments?.let {
            var args = FeedArgs.fromBundle(it)

            var post = Post("null", "${args.title}", "${args.description}")

            postViewModel.insert(post)
            Toast.makeText(context, "post saved", Toast.LENGTH_SHORT).show()
        }

        return view
    }


}
