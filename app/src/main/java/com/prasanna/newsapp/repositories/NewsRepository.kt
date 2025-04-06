package com.prasanna.newsapp.repositories

import com.prasanna.newsapp.model.Article
import com.prasanna.newsapp.util.Resource

interface NewsRepository {
    suspend fun getTopHeadlines(
        category: String
    ): Resource<List<Article>>

    suspend fun searchForNews(
        query: String
    ): Resource<List<Article>>
}