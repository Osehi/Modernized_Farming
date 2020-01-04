package com.example.modernpractice.data

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class PostDatabase:RoomDatabase() {

    abstract fun postDao(): PostDao

    companion object {

        @Volatile
        private var instance: PostDatabase? = null

        fun getInstance(context: Context): PostDatabase? {
            if(instance == null){
                synchronized(PostDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PostDatabase::class.java, "post_database"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance(){
            instance = null
        }

        private val roomCallback = object :RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsyncTask(instance)
                    .execute()

            }
        }
    }

    class PopulateDbAsyncTask(db:PostDatabase?): AsyncTask<Unit, Unit, Unit>() {
        private val postDao = db?.postDao()

        override fun doInBackground(vararg params: Unit?) {
            postDao?.insert(Post("https://me.you.com", "Samsung 6", "This device is truely smart; I use it to swime and works well thereafter"))
            postDao?.insert(Post("https://me.you1.com", "iPhone x", "Join a class with a sense that I have the best device in the world"))
        }
    }
}