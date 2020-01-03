package com.example.modernpractice.data

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface PostDao {

    @Insert
    fun insert(post:Post)

    @Update
    fun update(post:Post)

    @Delete
    fun delete(post:Post)

    @Query("DELETE FROM post_table")
    fun deleteAllPosts()

    @Query("SELECT * FROM post_table")
    fun getAllPost(): LiveData<List<Post>>
}