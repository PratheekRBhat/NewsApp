package com.pratheek.newsapp.api

import com.pratheek.newsapp.responses.NewsResponse
import com.pratheek.newsapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// Interface to communicate with newsapi.org using Retrofit
interface NewsAPI {

    /*
    * Method to get breaking news for a specific country.
    * The parameters of the method are the values requested by the API with `pageNumber` being used to display news in the form of pages for convenience.
    */
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "in",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

    /*
   * Method to search for specific news and get results for it based on a query entered by the user.
   * The parameters of the method are the values requested by the API with `pageNumber` being used to display news in the form of pages for convenience.
   */
    @GET("v2/everything")
    suspend fun searchNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>
}