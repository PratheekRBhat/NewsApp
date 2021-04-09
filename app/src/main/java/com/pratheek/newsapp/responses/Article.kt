package com.pratheek.newsapp.responses

/*
* A data class which contains the values found in the "article" object of the News API.
* A data class is used specifically to store data/state and using it can help reduce boilerplate code. Automatically implements constructors, getters, setters and other functionality.
*/
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)