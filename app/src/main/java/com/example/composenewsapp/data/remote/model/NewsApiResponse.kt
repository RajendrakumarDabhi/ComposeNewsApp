package com.example.composenewsapp.data.remote.model

import com.example.composenewsapp.domain.models.Article

data class NewsApiResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
