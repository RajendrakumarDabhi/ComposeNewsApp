package com.example.composenewsapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.composenewsapp.data.remote.api.NewsApi
import com.example.composenewsapp.domain.models.Article

class SearchNewsPagingSource(
    val newsApi: NewsApi,
    val source: String,
    val searchQuery: String
) : PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        TODO("Not yet implemented")
    }

    private var totalNewsCount = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val page = params.key ?: 1
            val newsResponse = newsApi.searchNews(searchQuery, source, page)
            totalNewsCount += newsResponse.articles.size
            LoadResult.Page(
                newsResponse.articles,
                prevKey = null,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1
            )
        } catch (ex: Exception) {
            LoadResult.Error(ex)
        }


    }

}