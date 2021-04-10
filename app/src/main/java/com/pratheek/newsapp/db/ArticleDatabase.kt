package com.pratheek.newsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pratheek.newsapp.responses.Article

// Room Database class
@Database(entities = [Article::class], version = 1)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object {
        /* Volatile = Writes to this field are immediately visible to other threads
        * LOCK = used to synchronize the database instance to ensure only one instance is used at a time.*/
        @Volatile
        private var instance: ArticleDatabase? = null
        private var LOCK = Any()

        /* Operator function = a function that is called every time an object of that class is created. Unlike Constructors, it is not used to initialize the members.
        * synchronized(LOCK) = used to synchronize the database instance among the threads i.e. only 1 instance of the database is created at a given time.*/
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
                Room.databaseBuilder(
                        context,
                        ArticleDatabase::class.java,
                        "article_db.db"
                ).build()
    }
}