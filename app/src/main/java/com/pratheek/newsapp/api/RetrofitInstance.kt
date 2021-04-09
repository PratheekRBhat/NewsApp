package com.pratheek.newsapp.api

import com.pratheek.newsapp.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* A retrofit singleton class that enables requests from any part of the codebase.
* Using companion object to enforce static behaviour of the objects within the braces. Kinda like using singleton but for some members only.
* Lazy implies that the members within the braces are initialised during it's first usage, rather than during declaration.
*/
class RetrofitInstance {
    companion object {
        private val retrofit by lazy {
            //A third party library that makes it easier to log API calls
            val logging = HttpLoggingInterceptor()
            //Sets levels of logging. This particular setting logs the response body.
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            //ConverterFactory is used to determine how to convert JSON to Kotlin. Here, GSON is used, which is Google's implementation of the conversion.
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        // API instance from the Retrofit builder
        val api by lazy {
            retrofit.create(NewsAPI::class.java)
        }
    }
}