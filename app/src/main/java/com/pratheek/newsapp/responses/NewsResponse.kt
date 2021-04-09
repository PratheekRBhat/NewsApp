package com.pratheek.newsapp.responses

/*
* A data class which contains the values found in the News API.
* A data class is used specifically to store data/state and using it can help reduce boilerplate code. Automatically implements constructors, getters, setters and other functionality.
*/
data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)