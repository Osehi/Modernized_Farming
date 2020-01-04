package com.example.modernpractice.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.modernpractice.data.Post
import com.example.modernpractice.data.PostRepository

class PostViewModel(application: Application):AndroidViewModel(application) {

    private var repository: PostRepository = PostRepository(application)

    private var allPosts: LiveData<List<Post>> = repository.getAllPosts()

    fun insert(post:Post){
        repository.insert(post)
    }

    fun update(post:Post){
        repository.update(post)
    }

    fun delete(post:Post){
        repository.delete(post)
    }

//    fun deleteAllPosts(){
//        repository.
//    }

    fun getAllPosts():LiveData<List<Post>>{
        return allPosts
    }


}