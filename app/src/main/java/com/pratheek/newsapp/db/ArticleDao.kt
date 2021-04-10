package com.pratheek.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pratheek.newsapp.responses.Article

/*
* LiveData is a class that notifies all it's listeners when a change is made. Very commonly used in architecture components to sync changes between the various parts.
* Data Access Object (DAO) is an interface between the application and the database. It's an API for Room Database.*/
@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateOrInsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<Article>

    @Delete
    suspend fun deleteArticle(article: Article)
}