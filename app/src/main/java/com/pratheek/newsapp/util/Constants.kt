package com.pratheek.newsapp.util

/*
* A utility class used to store constant values which can be accessed anywhere in the codebase
* Using companion object to enforce static behaviour of the objects within the braces. Kinda like using singleton but for some members only.
*/
class Constants {
    companion object {
        const val API_KEY = "ced1ea3691114a208cc4187412a754ee"
        const val BASE_URL = "https://newsapi.org"
    }
}