package com.example.composenewsapp.domain.usecases.news

import com.example.composenewsapp.domain.repositories.NewsRepository

class GetNewsUseCase constructor(private val newsRepository: NewsRepository) {
    fun invoke(sources: List<String>) = newsRepository.getNews(sources)
}