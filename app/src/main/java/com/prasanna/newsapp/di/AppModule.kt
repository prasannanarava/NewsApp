package com.prasanna.newsapp.di

import android.annotation.SuppressLint
import com.prasanna.newsapp.network.ApiInterface
import com.prasanna.newsapp.repositories.NewsRepository
import com.prasanna.newsapp.repositories.NewsRepositoryImpl
import com.prasanna.newsapp.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @SuppressLint("SuspiciousIndentation")
    @Provides
    @Singleton
    fun provideNewsApi(): ApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            return retrofit.create(ApiInterface::class.java)
    }


    @Provides
    @Singleton
    fun provideNewsRepository(newsApiService: ApiInterface) : NewsRepository {
        return NewsRepositoryImpl(newsApiService)
    }
}

