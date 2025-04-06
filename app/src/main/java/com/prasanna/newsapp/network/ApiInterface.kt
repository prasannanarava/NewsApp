package com.prasanna.newsapp.network

import com.prasanna.newsapp.model.NewsResponse
import com.prasanna.newsapp.util.Constants.Companion.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {

    // https://newsapi.org/v2/top-headlines?country=us&page=1&apiKey=API_KEY
    @GET("top-headlines")
    suspend fun getBreakingNews(
        @Query("category") category: String,
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = API_KEY
    ) : NewsResponse

    @GET("everything")
    suspend fun searchForNews(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String = API_KEY
    ) : NewsResponse
}