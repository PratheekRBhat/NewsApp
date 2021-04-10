package com.pratheek.newsapp.responses

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
* A data class which contains the values found in the "article" object of the News API.
* A data class is used specifically to store data/state and using it can help reduce boilerplate code. Automatically implements constructors, getters, setters and other functionality.
*/

@Entity(tableName = "articles")
data class Article(
        /*
        * The Article class is considered as a table in the Room Database and requires a primary key.
        * Nullable because not all articles are stored in the database and hence not all of them have IDs.
        */
        @PrimaryKey(autoGenerate = true)
        var id: Int? = null,
        val author: String,
        val content: String,
        val description: String,
        val publishedAt: String,
        val source: Source,
        val title: String,
        val url: String,
        val urlToImage: String
)