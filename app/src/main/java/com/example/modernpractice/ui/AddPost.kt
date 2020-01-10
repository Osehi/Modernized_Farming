package com.example.modernpractice.ui


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.Image
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast.LENGTH_LONG
import androidx.core.content.PermissionChecker
import androidx.core.content.PermissionChecker.checkPermission
import androidx.core.content.PermissionChecker.checkSelfPermission
import androidx.navigation.findNavController
import android.Manifest
import android.net.Uri

import com.example.modernpractice.R
import com.example.modernpractice.data.Post
import kotlinx.android.synthetic.main.add_post.*
import kotlinx.android.synthetic.main.add_post.view.*

/**
 * A simple [Fragment] subclass.
 */
class AddPost : Fragment() {

    private lateinit var adImageToIt: ImageView
    private lateinit var adToIt: EditText
    private lateinit var adToDescription: EditText
    private lateinit var loadImageButton:Button
    private var imageUriLoader: Uri? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.add_post, container, false)
        adImageToIt = view.findViewById(R.id.addImageId)
        adToIt = view.findViewById(R.id.addTitleId)
        adToDescription = view.findViewById(R.id.addDescriptionId)
        loadImageButton = view.findViewById(R.id.loadImageId)

        // capture image to post
        // add onClickListener to "choose image button"
        loadImageButton.setOnClickListener {
            // check runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(checkSelfPermission(context!!, Manifest.permission.READ_EXTERNAL_STORAGE) ==
                        PermissionChecker.PERMISSION_DENIED){
                    // permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    // show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE);

                }
                else {
                    // permission already granted
                    pickImageFromGallery();
                }
            }
            else {
                // system OS is < Marshmallow
                pickImageFromGallery();
            }

        }




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

    private fun pickImageFromGallery() {
        // intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        // image pick code
        private val IMAGE_PICK_CODE = 1000;
        // PERMISSION CODE
        private val PERMISSION_CODE = 1001;
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED){
                    // permission from popup granted
                    pickImageFromGallery()
                }
                else {
                    // permission from popup denied
                    Toast.makeText(context,"permission denied", Toast.LENGTH_SHORT ).show()
                }

            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            val contemtUri = data?.data
            imageUriLoader = contemtUri
            adImageToIt.setImageURI(contemtUri)
        }
    }


}
