package com.example.composenewsapp.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.composenewsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(val newsUseCases: NewsUseCases) : ViewModel() {
    val news = newsUseCases.getNewsUseCase.invoke(
        listOf("bbc-news", "abc-news", "al-jazeera-english")
    ).cachedIn(viewModelScope)
}
