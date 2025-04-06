package com.prasanna.newsapp.repositories

import com.prasanna.newsapp.model.Article
import com.prasanna.newsapp.network.ApiInterface
import com.prasanna.newsapp.util.Resource

class NewsRepositoryImpl(
    private val newsApiService: ApiInterface
) : NewsRepository {
    override suspend fun getTopHeadlines(category: String): Resource<List<Article>> {
        return try {
            val response = newsApiService.getBreakingNews(category = category)
            Resource.Success(data = response.articles)
        } catch (e: Exception) {
            Resource.Error("Failed to fetch News ${e.message}")
        }
    }

    override suspend fun searchForNews(query: String): Resource<List<Article>> {
        return try {
            val response = newsApiService.searchForNews(query = query)
            Resource.Success(data = response.articles)
        } catch (e: Exception) {
            Resource.Error("Failed to fetch News ${e.message}")
        }
    }

}