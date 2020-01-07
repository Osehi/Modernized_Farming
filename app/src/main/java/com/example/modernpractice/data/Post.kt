package com.example.modernpractice.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Entity(tableName = "post_table")
data class Post(


    var imageUrl: String? = null,
    var title: String? = null,
    var description: String? = null
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}