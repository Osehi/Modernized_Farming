package com.example.modernpractice.data

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

class PostRepository(application: Application) {

    private var postDao: PostDao

    private var allPosts: LiveData<List<Post>>

    init {
        val database: PostDatabase = PostDatabase.getInstance(
            application.applicationContext
        )!!
        postDao = database.postDao()
        allPosts = postDao.getAllPosts()
    }

    fun insert(post: Post) {
        val insertPostAsyncTask = InserPostAsyncTask(postDao).execute(post)
    }

    fun delete(post: Post) {
        val deletePostAsyncTask = DeletePostAsyncTask(postDao).execute(post)
    }

    fun update(post: Post) {
        val updateNoteAsyncTask = UpdatePostAsyncTask(postDao).execute(post)
    }

    fun deleteAllPosts() {
        val deleteAllPostsAsyncTask = DeleteAllPostsAsyncTask(postDao).execute()

    }

    fun getAllPosts(): LiveData<List<Post>> {
        return allPosts
    }


    companion object {
        private class InserPostAsyncTask(postDao: PostDao) : AsyncTask<Post, Unit, Unit>() {
            val postDao = postDao

            override fun doInBackground(vararg p0: Post?) {
                postDao.insert(p0[0]!!)
            }
        }

        private class UpdatePostAsyncTask(postDao: PostDao) : AsyncTask<Post, Unit, Unit>() {
            val postDao = postDao
            override fun doInBackground(vararg p0: Post?) {
                postDao.update(p0[0]!!)
            }
        }

        private class DeletePostAsyncTask(postDao: PostDao) : AsyncTask<Post, Unit, Unit>() {
            val postDao = postDao
            override fun doInBackground(vararg p0: Post?) {
                postDao.delete(p0[0]!!)
            }
        }


        private class DeleteAllPostsAsyncTask(postDao: PostDao) : AsyncTask<Post, Unit, Unit>() {
            val postDao = postDao
            override fun doInBackground(vararg p0: Post?) {
                postDao.deleteAllPosts()
            }
        }
    }


}