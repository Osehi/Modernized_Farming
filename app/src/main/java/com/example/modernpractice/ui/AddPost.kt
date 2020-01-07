package com.example.modernpractice.ui


import android.content.Context
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.navigation.findNavController

import com.example.modernpractice.R
import com.example.modernpractice.data.Post
import kotlinx.android.synthetic.main.add_post.*
import kotlinx.android.synthetic.main.add_post.view.*

/**
 * A simple [Fragment] subclass.
 */
class AddPost : Fragment() {

    private lateinit var adImageToIt: ImageButton
    private lateinit var adToIt: EditText
    private lateinit var adToDescription: EditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.add_post, container, false)
        adImageToIt = view.findViewById(R.id.addImageId)
        adToIt = view.findViewById(R.id.addTitleId)
        adToDescription = view.findViewById(R.id.addDescriptionId)


        var punch = view.findViewById<Button>(R.id.addPostId)
        punch.setOnClickListener {
            var action = AddPostDirections.actionAddPostToFeed(
                view.addTitleId.text.toString(),
                view.addDescriptionId.text.toString()
            )
            it.findNavController().navigate(action)

        }


        return view
    }


}
