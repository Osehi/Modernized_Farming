package com.example.modernpractice.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PostDao {

    @Insert
    fun insert(post:Post)

    @Update
    fun update(post:Post)

    @Delete
    fun delete(post:Post)

//    @Query("DELETE FROM post_table")
//    fun deleteAllPosts()

    @Query("SELECT * FROM post_table")
    fun getAllPosts(): LiveData<List<Post>>
}