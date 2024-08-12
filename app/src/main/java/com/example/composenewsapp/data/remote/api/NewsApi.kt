package com.example.composenewsapp.data.remote.api

import com.example.composenewsapp.data.remote.model.NewsApiResponse
import com.example.composenewsapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("q") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = Constants.KEY
    ): NewsApiResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = Constants.KEY
    ): NewsApiResponse
}
