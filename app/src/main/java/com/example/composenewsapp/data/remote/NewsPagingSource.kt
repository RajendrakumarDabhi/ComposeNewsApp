package com.example.composenewsapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.composenewsapp.data.remote.api.NewsApi
import com.example.composenewsapp.domain.models.Article

class NewsPagingSource(private val newsApi: NewsApi, private val sources: String) :
    PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    private var totalNewsCount: Int = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val page = params.key ?: 1
            val newsResponse = newsApi.getNews(sources = sources, page)
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