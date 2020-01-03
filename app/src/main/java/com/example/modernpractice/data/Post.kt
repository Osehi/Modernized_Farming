package com.example.modernpractice.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post_table")
data class Post(

    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    var imageUrl:String? = null,
    var title:String? = null,
    var description:String? = null
) {
}