package com.example.modernpractice.ui


import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG

import com.example.modernpractice.R
import kotlinx.android.synthetic.main.add_post.*

/**
 * A simple [Fragment] subclass.
 */
class AddPost : Fragment() {

    private lateinit var adImageToIt:ImageButton
    private lateinit var adToIt:EditText
    private lateinit var adToDescription:EditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.add_post, container, false)
        adImageToIt = view.findViewById(R.id.addImageId)
        adToIt = view.findViewById(R.id.addTitleId)
        adToDescription = view.findViewById(R.id.addDescriptionId)

        fun savePost(){
//            var postImage:Image = adImageToIt.setImageResource(R.drawable.post1)
            var title:String = adToIt.text.toString()
            var description:String = adToDescription.text.toString()

            if (title.trim().isEmpty() || description.trim().isEmpty()){

            }
        }


        return view
    }




}
