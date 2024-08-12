package com.example.composenewsapp.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.composenewsapp.data.remote.NewsPagingSource
import com.example.composenewsapp.data.remote.SearchNewsPagingSource
import com.example.composenewsapp.data.remote.api.NewsApi
import com.example.composenewsapp.domain.models.Article
import com.example.composenewsapp.domain.repositories.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(val newsApi: NewsApi) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        val config = PagingConfig(pageSize = 10, prefetchDistance = 2, maxSize = 100)
        return Pager(config, pagingSourceFactory = {
            NewsPagingSource(newsApi, sources = sources.joinToString(separator = ","))
        }).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        val config = PagingConfig(pageSize = 10, prefetchDistance = 2, maxSize = 100)
        return Pager(config, pagingSourceFactory = {
            SearchNewsPagingSource(
                newsApi,
                source = sources.joinToString(separator = ","),
                searchQuery = searchQuery
            )
        }).flow
    }


}